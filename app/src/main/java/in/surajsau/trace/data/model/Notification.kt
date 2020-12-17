package `in`.surajsau.trace.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Notification(
    @JsonProperty("id") val id: String,
    @JsonProperty("subject") val subject: NotificationSubject,
    @JsonProperty("unread") val unread: Boolean,
    @JsonProperty("repository") val repository: Repo
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class NotificationSubject(
    @JsonProperty("title") val title: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("type") val type: String
)