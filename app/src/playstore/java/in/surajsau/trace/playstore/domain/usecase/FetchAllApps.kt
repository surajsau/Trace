package `in`.surajsau.trace.playstore.domain.usecase

import `in`.surajsau.trace.playstore.domain.Repository
import javax.inject.Inject

class FetchAllApps @Inject constructor(private val repository: Repository) {

    fun invoke() = repository.fetchAllApps()
}
