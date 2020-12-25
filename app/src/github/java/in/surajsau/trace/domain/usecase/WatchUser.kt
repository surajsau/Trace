package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.repository.UserRepository
import javax.inject.Inject

class WatchUser @Inject constructor(
    private val repository: UserRepository
) {

    fun invoke() = repository.watchUser()
}
