package `in`.surajsau.trace.domain

import dagger.Binds
import dagger.Provides

abstract class RepositoryModule {

    @Binds
    @Provides
    abstract fun repository(repositoryImpl: RepositoryImpl): Repository
}
