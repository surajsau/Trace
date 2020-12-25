package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.ApiType
import `in`.surajsau.trace.domain.Repository
import javax.inject.Inject

class FetchNewGames @Inject constructor(
    private val repository: Repository
) {

    fun invoke() = repository.fetchGames(type = ApiType.NEW_GAME)
}
