package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.repository.AuthRepository
import android.app.Activity
import io.reactivex.Completable
import javax.inject.Inject

class Authenticate @Inject constructor(
    private val repository: AuthRepository
) {

    fun invoke(activity: Activity): Completable {
        repository.authenticate(activity)
        return repository.watchResult()
    }
}