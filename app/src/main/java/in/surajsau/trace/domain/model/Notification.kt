package `in`.surajsau.trace.domain.model

enum class NotificationType(val value: String) {
    ISSUE("issue");
}

data class Notification(
    val id: String,
    val title: String,
    val isUnread: Boolean,
    val repo: Repo,
    val url: String,
    val type: NotificationType,
    val isMerged: Boolean = false
)
