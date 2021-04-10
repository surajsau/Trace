package `in`.surajsau.trace.playstore.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ApplicationDetail(
    @JsonProperty("title") val title: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("summary") val summary: String,
    @JsonProperty("installs") val installs: String,
    @JsonProperty("minInstalls") val minInstalls: Int,
    @JsonProperty("maxInstalls") val maxInstalls: Int,
    @JsonProperty("score") val score: Double,
    @JsonProperty("scoreText") val scoreText: String,
    @JsonProperty("ratings") val ratings: Int,
    @JsonProperty("price") val price: Int,
    @JsonProperty("free") val free: Boolean,
    @JsonProperty("developerEmail") val developerEmail: String,
    @JsonProperty("developerWebsite") val developerWebsite: String,
    @JsonProperty("developerAddress") val developerAddress: String,
    @JsonProperty("developerId") val developerId: String,
)
