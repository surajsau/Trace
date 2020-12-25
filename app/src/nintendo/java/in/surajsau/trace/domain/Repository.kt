package `in`.surajsau.trace.domain

import `in`.surajsau.trace.data.service.V1ApiService
import `in`.surajsau.trace.domain.mapper.mapToDomain
import `in`.surajsau.trace.domain.models.Content
import `in`.surajsau.trace.domain.models.Price
import `in`.surajsau.trace.domain.paging.DiscountedGamesPagingSource
import `in`.surajsau.trace.domain.paging.NewGamesPagingSource
import `in`.surajsau.trace.domain.paging.RankingGamesPagingSource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
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
    fun watchGames(): Observable<PagingData<Content>>
}

class RepositoryImpl @Inject constructor(
    private val newGamesPagingSource: NewGamesPagingSource,
    private val rankingGamesPagingSource: RankingGamesPagingSource,
    private val discountedGamesPagingSource: DiscountedGamesPagingSource,
    private val apiV1: V1ApiService
) : Repository {

    private val games = BehaviorSubject.create<PagingData<Content>>()

    override fun fetchPrices(ids: List<Long>): Single<List<Price>> {
        return apiV1.price(ids = ids)
            .map { it.prices.map { price -> price.mapToDomain() } }
    }

    override fun fetchGames(type: ApiType): Completable {
        return Pager(
            config = PagingConfig(
                pageSize = 30,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                return@Pager when (type) {
                    ApiType.NEW_GAME -> newGamesPagingSource
                    ApiType.DISCOUNT_GAME -> discountedGamesPagingSource
                    ApiType.RANKING_GAME -> rankingGamesPagingSource
                }
            }
        ).flowable
            .doOnNext { games.onNext(it) }
            .ignoreElements()
    }

    override fun watchGames(): Observable<PagingData<Content>> {
        return games
    }
}
