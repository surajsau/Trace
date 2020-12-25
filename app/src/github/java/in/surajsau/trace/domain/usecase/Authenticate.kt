package `in`.surajsau.trace.domain.usecase

import `in`.surajsau.trace.domain.repository.AuthRepository
import android.app.Activity
import javax.inject.Inject

class Authenticate @Inject constructor(
    private val repository: AuthRepository
) {

    fun invoke(activity: Activity) {
        repository.authenticate(activity)
    }
}
