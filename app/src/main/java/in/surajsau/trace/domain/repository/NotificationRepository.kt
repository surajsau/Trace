package `in`.surajsau.trace.domain.repository

import `in`.surajsau.trace.data.api.NotificationApi
import `in`.surajsau.trace.domain.model.Notification
import `in`.surajsau.trace.domain.paging.NotificationPagingSource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

interface NotificationRepository {

    fun fetchNotifications(readOnly: Boolean = false): Completable

    fun watchNotifications(): Observable<PagingData<Notification>>
}

class NotificationRepositoryImpl @Inject constructor(
    private val api: NotificationApi,
    private val pagingSource: NotificationPagingSource
) : NotificationRepository {

    private val notifications = BehaviorSubject.create<PagingData<Notification>>()

    override fun fetchNotifications(readOnly: Boolean): Completable {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { pagingSource }
        ).flowable
            .doOnNext { notifications.onNext(it) }
            .ignoreElements()
    }

    override fun watchNotifications(): Observable<PagingData<Notification>> = notifications
}
