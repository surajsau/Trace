package `in`.surajsau.trace.playstore.data

import `in`.surajsau.trace.playstore.data.model.Applications
import `in`.surajsau.trace.playstore.data.model.Reviews
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("apps")
    fun getApps(): Single<Applications>

    @GET("apps/{appId}/similar")
    fun getSimilarApps(@Path("appId") appid: String): Single<Applications>

    @GET("apps/{appId}/reviews")
    fun getReviews(@Path("appId") appId: String): Single<Reviews>
}
