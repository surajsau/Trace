package `in`.surajsau.trace.domain.model

enum class OwnerType(val value: String) {
    USER("User"),
    ORGANISATION("Organization");

    companion object {
        fun from(strValue: String) = values().first { it.value == strValue }
    }
}

data class Repo(
    val id: Int,
    val name: String,
    val fullName: String,
    val owner: Owner,
    val isPrivate: Boolean,
    val description: String?,
    val isForked: Boolean,
    val languages: List<Language>,
    val starCount: Int,
    val forkCount: Int,
    val watchCount: Int
)

data class Owner(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val url: String,
    val type: OwnerType
)

data class Language(
    val title: String,
    val byteCount: Int
)
