package `in`.surajsau.trace.data

import `in`.surajsau.trace.data.interceptor.HeaderInterceptor
import `in`.surajsau.trace.data.api.RepoApi
import `in`.surajsau.trace.data.api.UserApi
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.firebase.auth.FirebaseAuth
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun preference(appPreferenceImpl: AppPreferenceImpl): AppPreference

    @Singleton
    @Binds
    abstract fun auth(authImpl: AuthImpl): Auth

    companion object {

        @Singleton
        @Provides
        fun firebaseAuth() = FirebaseAuth.getInstance()

        @Singleton
        @Provides
        fun headerInterceptor(preference: AppPreference) = HeaderInterceptor(preference = preference)

        @Singleton
        @Provides
        fun retrofit(headerInterceptor: HeaderInterceptor): Retrofit {
            val okhttp = OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addNetworkInterceptor(StethoInterceptor())
                .build()

            return Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okhttp)
                .build()
        }

        @Singleton
        @Provides
        fun userApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

        @Singleton
        @Provides
        fun repoApi(retrofit: Retrofit): RepoApi = retrofit.create(RepoApi::class.java)
    }
}
