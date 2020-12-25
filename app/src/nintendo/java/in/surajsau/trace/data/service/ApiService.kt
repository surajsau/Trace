package `in`.surajsau.trace.data.service

import `in`.surajsau.trace.data.models.ContentsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

// Reference: https://gist.github.com/Shy07/822eff655ec8da2717f269bc21c65976

interface ApiService {

    @GET("JP/ja/search/sales")
    fun discountedGames(
        @Query("count") count: Int,
        @Query("offset") offset: Int
    ): Single<ContentsResponse>

    @GET("JP/ja/search/new")
    fun newGames(
        @Query("count") count: Int,
        @Query("offset") offset: Int
    ): Single<ContentsResponse>

    @GET("JP/ja/search/ranking")
    fun gameRankings(
        @Query("count") count: Int,
        @Query("offset") offset: Int
    ): Single<ContentsResponse>
}
