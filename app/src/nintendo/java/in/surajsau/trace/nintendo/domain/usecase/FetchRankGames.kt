package `in`.surajsau.trace.nintendo.domain.usecase

import `in`.surajsau.trace.nintendo.domain.ApiType
import `in`.surajsau.trace.nintendo.domain.Repository
import javax.inject.Inject

class FetchRankGames @Inject constructor(
    private val repository: Repository
) {

    fun invoke() = repository.fetchGames(type = ApiType.RANKING_GAME)
}
