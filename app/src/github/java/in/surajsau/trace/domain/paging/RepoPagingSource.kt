package `in`.surajsau.trace.domain.paging

import `in`.surajsau.trace.data.api.RepoApi
import `in`.surajsau.trace.domain.mapper.mapToDomain
import `in`.surajsau.trace.domain.model.Repo
import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single

class RepoPagingSource constructor(
    private val repoApi: RepoApi
) : RxPagingSource<Int, Repo>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Repo>> {
        val pageNumber = params.key ?: 0
        return repoApi.repositories(pageNumber = pageNumber)
            .doOnError { LoadResult.Error<Int, Repo>(throwable = it) }
            .map { it.map { data -> data.mapToDomain() } }
            .map {
                LoadResult.Page(
                    data = it,
                    prevKey = if (pageNumber == 0) null else pageNumber - 1,
                    nextKey = pageNumber + 1
                )
            }
    }
}
