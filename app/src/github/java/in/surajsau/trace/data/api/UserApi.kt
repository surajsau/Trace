package `in`.surajsau.trace.data.api

import `in`.surajsau.trace.data.model.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface UserApi {

    @GET("user")
    fun user(): Single<User>
}
