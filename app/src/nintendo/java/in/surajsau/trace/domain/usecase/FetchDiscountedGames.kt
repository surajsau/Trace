package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.ApiType
import `in`.surajsau.trace.domain.Repository
import javax.inject.Inject

class FetchDiscountedGames @Inject constructor(
    private val repository: Repository
) {

    fun invoke() = repository.fetchGames(type = ApiType.DISCOUNT_GAME)
}
