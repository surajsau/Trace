package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.Repository

class WatchGames constructor(
    private val repository: Repository
) {
    fun invoke() = repository.watchGames()
}