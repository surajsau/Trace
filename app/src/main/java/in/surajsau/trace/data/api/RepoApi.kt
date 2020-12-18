package `in`.surajsau.trace.data.api

import `in`.surajsau.trace.data.model.Repo
import `in`.surajsau.trace.domain.repository.RepoType
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApi {

    @GET("user/repos")
    fun repositories(
        @Query("page") pageNumber: Int = 0,
        @Query("per_page") pageSize: Int = 20,
        @Query("type") type: String = RepoType.ALL.value
    ): Single<List<Repo>>
}
