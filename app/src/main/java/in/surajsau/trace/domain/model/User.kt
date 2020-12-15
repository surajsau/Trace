package `in`.surajsau.trace.domain.model

data class User(
    val id: Int,
    val imageUrl: String,
    val profileUrl: String,
    val name: String,
    val company: String,
    val location: String,
    val email: String,
    val bio: String,
    val blog: String,
    val followers: Int,
    val following: Int,
    val publicRepos: Int,
    val totalPrivateRepos: Int,
    val collaborators: Int
)
