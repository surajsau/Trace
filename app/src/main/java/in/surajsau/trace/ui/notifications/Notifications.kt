package `in`.surajsau.trace.ui.notifications

data class Notifications(
    val list: List<NotificationModel>
)

data class NotificationModel(
    val title: String,
    val repoTitle: String,
    val userImageUrl: String,
    val showUnreadMark: Boolean
)
