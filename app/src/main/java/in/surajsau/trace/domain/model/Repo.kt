package `in`.surajsau.trace.domain.model

enum class OwnerType(val value: String) {
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
    val isForked: Boolean
)

data class Owner(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val url: String,
    val type: OwnerType
)
