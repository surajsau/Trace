package `in`.surajsau.trace.nintendo.data.service

import `in`.surajsau.trace.nintendo.data.models.PricesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

// Reference: https://gist.github.com/Shy07/822eff655ec8da2717f269bc21c65976

interface V1ApiService {

    @GET("price?country=JP&ids=70010000009922&lang=jp")
    fun price(
        @Query("ids") ids: List<Long>
    ): Single<PricesResponse>
}
