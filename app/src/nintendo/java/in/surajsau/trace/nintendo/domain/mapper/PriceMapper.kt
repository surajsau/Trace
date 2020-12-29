package `in`.surajsau.trace.nintendo.domain.mapper

import `in`.surajsau.trace.nintendo.data.models.GamePrice
import `in`.surajsau.trace.nintendo.data.models.Price
import `in`.surajsau.trace.nintendo.domain.models.Duration

fun Price.mapToDomain() = `in`.surajsau.trace.nintendo.domain.models.Price(
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
