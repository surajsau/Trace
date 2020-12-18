package `in`.surajsau.trace.data.api

import `in`.surajsau.trace.data.model.User
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {

    @GET("user")
    fun user(): Single<User>
}
