package `in`.surajsau.trace.playstore.domain.usecase

import `in`.surajsau.trace.playstore.domain.Repository
import `in`.surajsau.trace.playstore.domain.model.Application
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class WatchApps @Inject constructor(private val repository: Repository) {

    fun invoke(): Observable<List<Application>> {
        return repository.watchAllApps()
    }
}
