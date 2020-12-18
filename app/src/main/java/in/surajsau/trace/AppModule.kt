package `in`.surajsau.trace

import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.androidx.SchedulerProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun provideSchedulerProvider(schedulerProviderImpl: SchedulerProviderImpl): SchedulerProvider
}
