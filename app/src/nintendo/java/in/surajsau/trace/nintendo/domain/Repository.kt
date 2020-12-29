package `in`.surajsau.trace.nintendo.domain

import `in`.surajsau.trace.nintendo.data.service.ApiService
import `in`.surajsau.trace.nintendo.data.service.V1ApiService
import `in`.surajsau.trace.nintendo.domain.mapper.mapToDomain
import `in`.surajsau.trace.nintendo.domain.models.Content
import `in`.surajsau.trace.nintendo.domain.models.Price
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

enum class ApiType {
    NEW_GAME, RANKING_GAME, DISCOUNT_GAME
}

interface Repository {
    fun fetchGames(type: ApiType): Completable
    fun fetchPrices(ids: List<Long>): Single<List<Price>>
    fun watchGames(): Observable<List<Content>>
}

class RepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val apiV1: V1ApiService
) : Repository {

    private val games = BehaviorSubject.create<List<Content>>()

    override fun fetchPrices(ids: List<Long>): Single<List<Price>> {
        return apiV1.price(ids = ids)
            .map { it.prices.map { price -> price.mapToDomain() } }
    }

    override fun fetchGames(type: ApiType): Completable {
        val source = when (type) {
            ApiType.NEW_GAME -> api.newGames(30, 0)
            ApiType.DISCOUNT_GAME -> api.discountedGames(30, 0)
            ApiType.RANKING_GAME -> api.gameRankings(30, 0)
        }

        return source
            .map { it.contents }
            .doOnSuccess { games.onNext(it.map { content -> content.mapToDomain() }) }
            .ignoreElement()
    }

    override fun watchGames(): BehaviorSubject<List<Content>> = games
}
