package `in`.surajsau.trace.nintendo.data

import `in`.surajsau.trace.nintendo.data.service.ApiService
import `in`.surajsau.trace.nintendo.data.service.V1ApiService
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EcRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class V1Retrofit

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
    @EcRetrofit
    fun retrofit(okhttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okhttpClient)
            .baseUrl("https://ec.nintendo.com/api/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    @Provides
    @V1Retrofit
    fun v1Retrofit(okhttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okhttpClient)
            .baseUrl("https://api.ec.nintendo.com/v1/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    @Provides
    fun apiService(@EcRetrofit retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    fun v1ApiService(@V1Retrofit retrofit: Retrofit) = retrofit.create(V1ApiService::class.java)
}
