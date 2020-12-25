package `in`.surajsau.trace.data

import `in`.surajsau.trace.data.service.ApiService
import `in`.surajsau.trace.data.service.V1ApiService
import `in`.surajsau.trace.domain.Repository
import `in`.surajsau.trace.domain.RepositoryImpl
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun repository(repositoryImpl: RepositoryImpl): Repository

    companion object {

        /**
         * As per this gist,
         * https://gist.github.com/Shy07/822eff655ec8da2717f269bc21c65976
         *
         * Nintendo APIs are of two different end-points.
         * - https://ec.nintendo.com/api/..
         * - https://api.ec.nintendo.com/v1/..
         */

        @Provides
        @Singleton
        fun okhttp() = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        @Provides
        @Singleton
        @Named("ec_retrofit")
        fun retrofit(okhttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .client(okhttpClient)
                .baseUrl("https://ec.nintendo.com/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        @Named("v1_retrofit")
        fun v1Retrofit(okhttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .client(okhttpClient)
                .baseUrl("https://api.ec.nintendo.com/v1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun apiService(@Named("ec_retrofit")retrofit: Retrofit) = retrofit.create(ApiService::class.java)

        @Provides
        @Singleton
        fun v1ApiService(@Named("v1_retrofit")retrofit: Retrofit) = retrofit.create(V1ApiService::class.java)
    }
}
