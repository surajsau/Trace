package `in`.surajsau.trace.nintendo.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Images(@JsonProperty("images") val images: List<Image>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Image(@JsonProperty("url") val url: String)
