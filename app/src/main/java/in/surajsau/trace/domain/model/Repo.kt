package `in`.surajsau.trace.domain.model

data class Repo(
    val id: Int,
    val name: String,
    val fullName: String,
    val owner: User,
    val isPrivate: Boolean,
    val description: String,
    val fork: Boolean
)
