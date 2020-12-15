package `in`.surajsau.trace.data.interceptor

import `in`.surajsau.trace.data.AppPreference
import `in`.surajsau.trace.data.PrefKey
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor constructor(private val preference: AppPreference) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val token = preference.get(key = PrefKey.TOKEN)

        val newRequest = request.newBuilder()
            .header("Authorization", "token $token")
            .build()

        return chain.proceed(newRequest)
    }
}
