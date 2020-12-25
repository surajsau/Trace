package `in`.surajsau.trace.domain.paging

import `in`.surajsau.trace.data.service.ApiService
import `in`.surajsau.trace.domain.mapper.mapToDomain
import `in`.surajsau.trace.domain.models.Content
import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class NewGamesPagingSource @Inject constructor(
    private val apiService: ApiService
) : RxPagingSource<Int, Content>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Content>> {
        val pageNumber = params.key ?: 0
        return apiService.newGames(count = 30, offset = pageNumber)
            .map { it.contents.map { content -> content.mapToDomain() } }
            .doOnError { LoadResult.Error<Int, Content>(throwable = it) }
            .map {
                LoadResult.Page(
                    data = it,
                    nextKey = pageNumber + 1,
                    prevKey = if (pageNumber == 0) null else pageNumber - 1
                )
            }
    }
}