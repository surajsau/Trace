package `in`.surajsau.trace.nintendo.domain.models

data class Content(
    val id: Long,
    val contentType: String,
    val disclaimer: String?,
    val dominantColors: List<String>?,
    val formalName: String,
    val heroBannerUrl: String,
    val isNew: String,
    val publicStatus: String,
    val releaseDate: String,
    val strongDisclaimer: String?,
    val tags: List<Tag>?,
    val screenShots: List<String>?,
    val targetTitles: List<String>?
)
