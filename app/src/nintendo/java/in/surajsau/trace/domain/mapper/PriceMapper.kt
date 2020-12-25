package `in`.surajsau.trace.domain.mapper

import `in`.surajsau.trace.data.models.GamePrice
import `in`.surajsau.trace.data.models.Price
import `in`.surajsau.trace.domain.models.Duration

fun Price.mapToDomain() = `in`.surajsau.trace.domain.models.Price(
    titleId = titleId,
    salesStatus = salesStatus,
    regularPrice = regularPrice.amount,
    discountedPrice = discountedPrice?.amount,
    discountDuration = discountedPrice?.getDuration()
)

fun GamePrice.getDuration() = Duration(
    from = startDateTime,
    to = endDateTime
)
