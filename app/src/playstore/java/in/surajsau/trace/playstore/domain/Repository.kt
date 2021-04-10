package `in`.surajsau.trace.playstore.domain

import `in`.surajsau.trace.playstore.data.ApiService
import `in`.surajsau.trace.playstore.domain.mapper.mapToDomain
import `in`.surajsau.trace.playstore.domain.model.Application
import `in`.surajsau.trace.playstore.domain.model.Review
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

enum class ApiType {
    NEW_GAME, RANKING_GAME, DISCOUNT_GAME
}

interface Repository {
    fun fetchAllApps(): Completable
    fun fetchReviews(appId: String): Completable
    fun fetchSimilarApps(appId: String): Completable
    fun watchReviews(): Observable<List<Review>>
    fun watchAllApps(): Observable<List<Application>>
    fun watchSimilarApps(): Observable<List<Application>>
}

class RepositoryImpl @Inject constructor(
    private val api: ApiService,
) : Repository {

    private val apps = PublishSubject.create<List<Application>>()

    private val similarApps = PublishSubject.create<List<Application>>()

    private val reviews = PublishSubject.create<List<Review>>()

    override fun fetchAllApps(): Completable {
        return api.getApps()
            .map { it.results.map { application -> application.mapToDomain() } }
            .doOnSuccess { apps.onNext(it) }
            .ignoreElement()
    }

    override fun fetchReviews(appId: String): Completable {
        return api.getReviews(appId)
            .map { it.result.data.map { review -> review.mapToDomain() } }
            .doOnSuccess { reviews.onNext(it) }
            .ignoreElement()
    }

    override fun fetchSimilarApps(appId: String): Completable {
        return api.getSimilarApps(appId)
            .map { it.results.map { application -> application.mapToDomain() } }
            .doOnSuccess { similarApps.onNext(it) }
            .ignoreElement()
    }

    override fun watchReviews(): Observable<List<Review>> = reviews

    override fun watchAllApps(): Observable<List<Application>> = apps

    override fun watchSimilarApps(): Observable<List<Application>> = similarApps
}
