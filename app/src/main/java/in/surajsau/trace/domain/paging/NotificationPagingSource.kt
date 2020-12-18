package `in`.surajsau.trace.domain.paging

import `in`.surajsau.trace.data.api.NotificationApi
import `in`.surajsau.trace.domain.mapper.mapToDomain
import `in`.surajsau.trace.domain.model.Notification
import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single

class NotificationPagingSource constructor(
    private val notificationApi: NotificationApi
) : RxPagingSource<Int, Notification>() {
    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Notification>> {
        val pageNumber = params.key ?: 0
        return notificationApi.notifications(pageNumber = pageNumber)
            .map { it.map { data -> data.mapToDomain() } }
            .doOnError { LoadResult.Error<Int, Notification>(throwable = it) }
            .map {
                LoadResult.Page(
                    data = it,
                    nextKey = pageNumber + 1,
                    prevKey = if (pageNumber == 0) null else pageNumber - 1
                )
            }
    }
}
