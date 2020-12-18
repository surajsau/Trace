package `in`.surajsau.trace.domain.repository

import `in`.surajsau.trace.data.api.RepoApi
import `in`.surajsau.trace.domain.model.Repo
import `in`.surajsau.trace.domain.paging.RepoPagingSource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

enum class RepoType(val value: String) {
    ALL("all"),
    OWNER("owner"),
    PUBLIC("public"),
    PRIVATE("private"),
    MEMBER("member")
}

interface RepoRepository {

    fun fetchRepos(): Completable

    fun watchRepos(): Observable<PagingData<Repo>>
}

class RepoRepositoryImpl @Inject constructor(
    private val repoApi: RepoApi
) : RepoRepository {

    private val repos = BehaviorSubject.create<PagingData<Repo>>()

    override fun fetchRepos(): Completable {
        return Pager(
            initialKey = 0,
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { RepoPagingSource(repoApi = repoApi) }
        ).flowable
            .doOnNext { repos.onNext(it) }
            .ignoreElements()
    }

    override fun watchRepos(): BehaviorSubject<PagingData<Repo>> = repos
}
