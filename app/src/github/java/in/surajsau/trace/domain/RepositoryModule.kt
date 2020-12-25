package `in`.surajsau.trace.domain

import `in`.surajsau.trace.domain.repository.AuthRepository
import `in`.surajsau.trace.domain.repository.AuthRepositoryImpl
import `in`.surajsau.trace.domain.repository.NotificationRepository
import `in`.surajsau.trace.domain.repository.NotificationRepositoryImpl
import `in`.surajsau.trace.domain.repository.RepoRepository
import `in`.surajsau.trace.domain.repository.RepoRepositoryImpl
import `in`.surajsau.trace.domain.repository.UserRepository
import `in`.surajsau.trace.domain.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun authRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Singleton
    @Binds
    abstract fun userRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Singleton
    @Binds
    abstract fun repoRepository(repoRepositoryImpl: RepoRepositoryImpl): RepoRepository

    @Singleton
    @Binds
    abstract fun notificationRepository(notificationRepositoryImpl: NotificationRepositoryImpl): NotificationRepository
}
