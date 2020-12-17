package `in`.surajsau.trace.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
    @JsonProperty("id") val id: Int,
    @JsonProperty("avatar_url") val imageUrl: String,
    @JsonProperty("html_url") val profileUrl: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("company") val company: String?,
    @JsonProperty("location") val location: String?,
    @JsonProperty("email") val email: String,
    @JsonProperty("bio") val bio: String?,
    @JsonProperty("blog") val blog: String?,
    @JsonProperty("followers") val followers: Int,
    @JsonProperty("following") val following: Int,
    @JsonProperty("public_repos") val publicRepos: Int,
    @JsonProperty("total_private_repos") val totalPrivateRepos: Int,
    @JsonProperty("collaborators") val collaborators: Int,
    @JsonProperty("login") val handle: String
)
