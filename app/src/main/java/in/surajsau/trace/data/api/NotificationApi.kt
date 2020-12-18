package `in`.surajsau.trace.data.api

import `in`.surajsau.trace.data.model.Notification
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NotificationApi {

    @GET("notifications")
    fun notifications(
        @Query("all") read: Boolean = false,
        @Query("per_page") pageSize: Int = 20
    ): Single<List<Notification>>
}
