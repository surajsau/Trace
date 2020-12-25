package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.repository.NotificationRepository
import javax.inject.Inject

class WatchNotifications @Inject constructor(
    private val repository: NotificationRepository
) {

    fun invoke() = repository.watchNotifications()
}
