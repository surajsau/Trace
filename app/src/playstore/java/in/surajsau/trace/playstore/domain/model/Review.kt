package `in`.surajsau.trace.playstore.domain.model

data class Review(
    val id: String,
    val name: String,
    val image: String,
    val date: String,
    val score: String,
    val url: String,
    val text: String,
    val appVersion: String,
)
