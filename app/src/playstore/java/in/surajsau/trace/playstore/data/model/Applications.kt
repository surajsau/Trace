package `in`.surajsau.trace.playstore.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Applications(
    @JsonProperty("result") val results: List<Application>,
    @JsonProperty("next") val nextPageUrl: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Application(
    @JsonProperty("title") val title: String,
    @JsonProperty("appId") val appId: String,
    @JsonProperty("icon") val icon: String,
    @JsonProperty("developerId") val developerId: String,
    @JsonProperty("priceText") val priceText: String,
    @JsonProperty("price") val price: Int,
    @JsonProperty("free") val free: Boolean,
    @JsonProperty("summary") val summary: String,
    @JsonProperty("scoreText") val scoreText: String,
    @JsonProperty("score") val score: Double,
    @JsonProperty("playstoreUrl") val url: String,
    @JsonProperty("permissions") val permissionsUrl: String,
    @JsonProperty("similarUrl") val similarUrl: String,
    @JsonProperty("reviewsUrl") val reviewsUrl: String,
)
