package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.repository.RepoRepository
import javax.inject.Inject

class WatchPinnedRepos @Inject constructor(
    private val repository: RepoRepository
) {

    fun invoke() = repository.watchPinnedRepos()
}
