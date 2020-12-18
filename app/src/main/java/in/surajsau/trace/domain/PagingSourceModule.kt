package `in`.surajsau.trace.domain

import `in`.surajsau.trace.data.api.NotificationApi
import `in`.surajsau.trace.data.api.RepoApi
import `in`.surajsau.trace.domain.paging.NotificationPagingSource
import `in`.surajsau.trace.domain.paging.RepoPagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class PagingSourceModule {

    @Singleton
    @Provides
    fun notificationPagingSource(notificationApi: NotificationApi) =
        NotificationPagingSource(notificationApi = notificationApi)

    @Singleton
    @Provides
    fun repoPagingSource(repoApi: RepoApi) = RepoPagingSource(repoApi = repoApi)
}
