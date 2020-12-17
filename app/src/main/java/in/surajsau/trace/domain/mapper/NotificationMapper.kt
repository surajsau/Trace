package `in`.surajsau.trace.domain.mapper

import `in`.surajsau.trace.data.model.Notification
import `in`.surajsau.trace.domain.model.NotificationType

fun Notification.mapToDomain() = `in`.surajsau.trace.domain.model.Notification(
    id = id,
    title = subject.title,
    isUnread = unread,
    repo = repository.mapToDomain(),
    url = subject.url,
    type = subject.type.mapToNotificationType()
)

fun String.mapToNotificationType() = NotificationType.valueOf(value = this)
