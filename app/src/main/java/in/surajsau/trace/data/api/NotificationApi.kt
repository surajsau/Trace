package `in`.surajsau.trace.data.api

import `in`.surajsau.trace.data.model.Notification
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NotificationApi {

    @GET("notifications")
    fun notifications(
        @Query("all") read: Boolean = false,
        @Query("page") pageNumber: Int = 0,
        @Query("per_page") pageSize: Int = 20
    ): Single<List<Notification>>
}
