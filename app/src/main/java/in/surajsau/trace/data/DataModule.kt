package `in`.surajsau.trace.data

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
        fun retrofit(): Retrofit {
            val okhttp = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()

            return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okhttp)
                .build()
        }
    }
}
