package `in`.surajsau.trace.nintendo.domain.usecase

import `in`.surajsau.trace.nintendo.domain.ApiType
import `in`.surajsau.trace.nintendo.domain.Repository
import javax.inject.Inject

class FetchDiscountedGames @Inject constructor(
    private val repository: Repository
) {

    fun invoke() = repository.fetchGames(type = ApiType.DISCOUNT_GAME)
}
