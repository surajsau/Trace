package `in`.surajsau.trace.nintendo.domain.mapper

import `in`.surajsau.trace.nintendo.data.models.Content
import `in`.surajsau.trace.nintendo.data.models.Images
import `in`.surajsau.trace.nintendo.domain.models.Tag

fun Content.mapToDomain() = `in`.surajsau.trace.nintendo.domain.models.Content(
    id = id,
    contentType = contentType,
    disclaimer = disclaimer,
    dominantColors = dominantColors,
    formalName = formalName,
    heroBannerUrl = heroBannerUrl,
    isNew = isNew,
    publicStatus = publicStatus,
    releaseDate = releaseDate,
    strongDisclaimer = strongDisclaimer,
    tags = tags?.map { Tag(value = it) },
    screenShots = screenshots?.flatMap(Images::toList),
    targetTitles = targetTitles
)

fun Images.toList() = images.map { image -> image.url }