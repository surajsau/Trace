package `in`.surajsau.trace.playstore.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Reviews(
    @JsonProperty("results") val result: ReviewsData
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ReviewsData(
    @JsonProperty("data") val data: List<Review>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Review(
    @JsonProperty("id") val id: String,
    @JsonProperty("userName") val userName: String,
    @JsonProperty("userImage") val userImage: String,
    @JsonProperty("date") val date: String,
    @JsonProperty("score") val score: Int,
    @JsonProperty("scoreText") val scoreText: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("text") val text: String,
    @JsonProperty("version") val version: String,
    @JsonProperty("criterias") val criterias: List<ReviewCriteria>
)

data class ReviewCriteria(
    val criteria: String,
    val rating: Int
)
