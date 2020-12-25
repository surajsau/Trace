package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.repository.NotificationRepository
import javax.inject.Inject

class FetchUnreadNotifications @Inject constructor(
    private val repository: NotificationRepository
) {

    fun invoke() = repository.fetchNotifications(readOnly = false)
}
