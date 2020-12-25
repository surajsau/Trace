package `in`.surajsau.trace.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Owner(
    @JsonProperty("id") val id: Int,
    @JsonProperty("login") val login: String,
    @JsonProperty("avatar_url") val avatarUrl: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("html_url") val htmlUrl: String,
    @JsonProperty("type") val type: String
)
