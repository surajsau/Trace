package `in`.surajsau.trace.playstore.data

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    /**
     * As per this gist,
     * https://gist.github.com/Shy07/822eff655ec8da2717f269bc21c65976
     *
     * Nintendo APIs are of two different end-points.
     * - https://ec.nintendo.com/api/..
     * - https://api.ec.nintendo.com/v1/..
     */

    @Provides
    fun okhttp() = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    @Provides
    fun retrofit(okhttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okhttpClient)
            .baseUrl("http://localhost:3000/api/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    @Provides
    fun apiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)
}
