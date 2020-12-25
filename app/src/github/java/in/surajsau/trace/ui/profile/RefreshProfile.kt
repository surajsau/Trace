package `in`.surajsau.trace.ui.profile

import `in`.surajsau.trace.domain.usecase.FetchPinnedRepos
import `in`.surajsau.trace.domain.usecase.FetchUser
import javax.inject.Inject

class RefreshProfile @Inject constructor(
    private val fetchUser: FetchUser,
    private val fetchPinnedRepos: FetchPinnedRepos
) {

    fun invoke() = fetchUser.invoke()
        .andThen(fetchPinnedRepos.invoke())
}
