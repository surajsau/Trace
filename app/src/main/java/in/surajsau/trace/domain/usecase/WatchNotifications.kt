package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.repository.NotificationRepository

class WatchNotifications constructor(
    private val repository: NotificationRepository
) {

    fun invoke() = repository.watchNotifications()
}
