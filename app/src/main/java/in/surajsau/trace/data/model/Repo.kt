package `in`.surajsau.trace.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Repo(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("full_name")val fullName: String
)
