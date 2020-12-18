package `in`.surajsau.trace.domain.model

enum class NotificationType(val value: String) {
    RELEASE("Release"),
    PULL_REQUEST("PullRequest"),
    ISSUE("issue");

    companion object {
        fun from(strValue: String) = values().first { it.value == strValue }
    }
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
