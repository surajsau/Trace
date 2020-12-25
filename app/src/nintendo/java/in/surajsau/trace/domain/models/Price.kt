package `in`.surajsau.trace.domain.models

data class Price(
    val titleId: Long,
    val salesStatus: String,
    val regularPrice: String,
    val discountedPrice: String?,
    val discountDuration: Duration?
)
