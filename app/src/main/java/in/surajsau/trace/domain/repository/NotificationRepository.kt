package `in`.surajsau.trace.domain.repository

import `in`.surajsau.trace.data.user.NotificationApi
import `in`.surajsau.trace.domain.mapper.mapToDomain
import `in`.surajsau.trace.domain.model.Notification
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

interface NotificationRepository {

    fun fetchNotifications(readOnly: Boolean = false): Completable

    fun watchNotifications(): Observable<List<Notification>>
}

class NotificationRepositoryImpl constructor(
    private val api: NotificationApi
) : NotificationRepository {

    private val notifications = BehaviorSubject.create<List<Notification>>()

    override fun fetchNotifications(readOnly: Boolean): Completable {
        return api.notifications(read = readOnly)
            .doOnSuccess { response ->
                notifications.onNext(response.map { it.mapToDomain() })
            }
            .ignoreElement()
    }

    override fun watchNotifications() = notifications
}
