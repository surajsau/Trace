package `in`.surajsau.trace.nintendo.data.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ContentsResponse(
    @JsonProperty("contents") val contents: List<Content>,
    @JsonProperty("length") val length: Int,
    @JsonProperty("offset") val offset: Int,
    @JsonProperty("total") val total: Int
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Content(
    @JsonProperty("id") val id: Long,
    @JsonProperty("content_type") val contentType: String,
    @JsonProperty("disclaimer") val disclaimer: String?,
    @JsonProperty("dominant_colors") val dominantColors: List<String>?,
    @JsonProperty("formal_name") val formalName: String,
    @JsonProperty("hero_banner_url") val heroBannerUrl: String,
    @JsonProperty("is_new") val isNew: String,
    @JsonProperty("public_status") val publicStatus: String,
    @JsonProperty("release_date_on_eshop") val releaseDate: String,
    @JsonProperty("strong_disclaimer") val strongDisclaimer: String?,
    @JsonProperty("tags") val tags: List<String>?,
    @JsonProperty("target_titles") val targetTitles: List<String>?,
    @JsonProperty("screenshots") val screenshots: List<Images>?
)


