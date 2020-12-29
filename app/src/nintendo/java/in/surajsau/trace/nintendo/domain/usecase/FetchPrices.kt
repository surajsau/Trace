package `in`.surajsau.trace.nintendo.domain.usecase

import `in`.surajsau.trace.nintendo.domain.Repository
import javax.inject.Inject

class FetchPrices @Inject constructor(
    private val repository: Repository
) {
    fun invoke(id: Long) = repository.fetchPrices(ids = listOf(id))
}
