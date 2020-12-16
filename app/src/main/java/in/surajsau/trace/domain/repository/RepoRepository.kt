package `in`.surajsau.trace.domain.repository

import `in`.surajsau.trace.data.user.RepoApi
import io.reactivex.Completable
import javax.inject.Inject

enum class RepoType(val value: String) {
    ALL("all"),
    OWNER("owner"),
    PUBLIC("public"),
    PRIVATE("private"),
    MEMBER("member")
}

interface RepoRepository {

    fun fetchAll(): Completable
}

class RepoRepositoryImpl @Inject constructor(
    private val repoApi: RepoApi
) : RepoRepository {

    override fun fetchAll(): Completable {
        return repoApi.repositories()
            .ignoreElement()
    }
}
