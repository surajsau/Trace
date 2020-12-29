package `in`.surajsau.trace.nintendo.domain.usecase

import `in`.surajsau.trace.nintendo.domain.Repository
import javax.inject.Inject

class WatchGames @Inject constructor(
    private val repository: Repository
) {
    fun invoke() = repository.watchGames()
}
