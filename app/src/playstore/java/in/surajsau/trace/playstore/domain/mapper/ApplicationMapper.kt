package `in`.surajsau.trace.playstore.domain.mapper

import `in`.surajsau.trace.playstore.data.model.Application

fun Application.mapToDomain(): `in`.surajsau.trace.playstore.domain.model.Application {
    return `in`.surajsau.trace.playstore.domain.model.Application(
        title = this.title,
        appId = this.appId,
        icon = this.icon,
        developerId = this.developerId,
        priceText = this.priceText,
        scoreText = this.scoreText,
        isFree = this.free,
        summary = this.summary,
        url = this.url
    )
}
