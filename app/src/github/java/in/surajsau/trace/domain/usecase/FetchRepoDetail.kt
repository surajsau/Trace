package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.repository.RepoRepository
import javax.inject.Inject

class FetchRepoDetail @Inject constructor(
    private val repository: RepoRepository
) {
    fun invoke(repoApiUrl: String) = repository.fetchRepoDetail(url = repoApiUrl)
}
