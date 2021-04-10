package `in`.surajsau.trace.playstore.domain.usecase

import `in`.surajsau.trace.playstore.domain.Repository
import `in`.surajsau.trace.playstore.domain.model.Application
import javax.inject.Inject

class FetchAppReviews @Inject constructor(private val repository: Repository) {

    fun invoke(application: Application) = repository.fetchReviews(application.appId)
}
