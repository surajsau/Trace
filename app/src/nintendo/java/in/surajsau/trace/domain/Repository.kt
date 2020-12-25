package `in`.surajsau.trace.domain

import `in`.surajsau.trace.data.service.V1ApiService
import `in`.surajsau.trace.domain.mapper.mapToDomain
import `in`.surajsau.trace.domain.models.Price
import `in`.surajsau.trace.domain.paging.DiscountedGamesPagingSource
import `in`.surajsau.trace.domain.paging.NewGamesPagingSource
import `in`.surajsau.trace.domain.paging.RankingGamesPagingSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface Repository {
    fun fetchPrices(ids: List<Long>): Single<List<Price>>
}

class RepositoryImpl @Inject constructor(
    private val newGamesPagingSource: NewGamesPagingSource,
    private val rankingGamesPagingSource: RankingGamesPagingSource,
    private val discountedGamesPagingSource: DiscountedGamesPagingSource,
    private val apiV1: V1ApiService
) : Repository {

    override fun fetchPrices(ids: List<Long>): Single<List<Price>> {
        return apiV1.price(ids = ids)
            .map { it.prices.map { price -> price.mapToDomain() } }
    }
}
