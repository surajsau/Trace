package `in`.surajsau.trace.data

import com.google.firebase.auth.FirebaseAuth
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun preference(appPreferenceImpl: AppPreferenceImpl): AppPreference

    companion object {

        @Singleton
        @Provides
        fun firebaseAuth() = FirebaseAuth.getInstance()

        @Singleton
        @Provides
        fun auth(firebaseAuth: FirebaseAuth) = Auth(firebaseAuth = firebaseAuth)
    }
}
