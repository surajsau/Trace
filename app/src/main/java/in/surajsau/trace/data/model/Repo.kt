package `in`.surajsau.trace.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Repo(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("full_name")val fullName: String,
    @JsonProperty("owner") val owner: Owner,
    @JsonProperty("private") val private: Boolean,
    @JsonProperty("description") val description: String?,
    @JsonProperty("fork") val fork: Boolean
)
