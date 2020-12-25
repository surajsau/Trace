package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.repository.AuthRepository
import javax.inject.Inject

class WatchAuthentication @Inject constructor(
    private val repository: AuthRepository
) {

    fun invoke() = repository.watchResult()
}
