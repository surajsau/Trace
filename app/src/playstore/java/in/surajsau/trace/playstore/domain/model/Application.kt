package `in`.surajsau.trace.playstore.domain.model

data class Application(
    val title: String,
    val appId: String,
    val icon: String,
    val developerId: String,
    val priceText: String,
    val isFree: Boolean,
    val summary: String,
    val scoreText: String,
    val url: String
)
