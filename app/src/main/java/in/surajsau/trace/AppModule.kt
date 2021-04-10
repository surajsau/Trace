package `in`.surajsau.trace

import `in`.surajsau.trace.androidx.ResourceProvider
import `in`.surajsau.trace.androidx.ResourceProviderImpl
import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.androidx.SchedulerProviderImpl
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun provideSchedulerProvider(schedulerProviderImpl: SchedulerProviderImpl): SchedulerProvider

    companion object {

        @Singleton
        @Provides
        fun provideResourceProvider(@ApplicationContext context: Context): ResourceProvider {
            return ResourceProviderImpl(context)
        }
    }
}
