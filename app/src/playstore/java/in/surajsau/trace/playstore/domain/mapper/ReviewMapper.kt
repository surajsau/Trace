package `in`.surajsau.trace.playstore.domain.mapper

import `in`.surajsau.trace.playstore.data.model.Review

fun Review.mapToDomain(): `in`.surajsau.trace.playstore.domain.model.Review {
    return `in`.surajsau.trace.playstore.domain.model.Review(
        id = this.id,
        name = this.userName,
        image = this.userImage,
        date = this.date,
        score = this.scoreText,
        url = this.url,
        text = this.text,
        appVersion = this.version
    )
}
