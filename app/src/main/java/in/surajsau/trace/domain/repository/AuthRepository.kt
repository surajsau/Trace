package `in`.surajsau.trace.domain.repository

import `in`.surajsau.trace.androidx.Optional
import `in`.surajsau.trace.data.AppPreference
import `in`.surajsau.trace.data.Auth
import android.app.Activity
import io.reactivex.Completable
import io.reactivex.subjects.BehaviorSubject
import java.lang.Exception
import javax.inject.Inject

interface AuthRepository {

    fun authenticate(authCallbackActivity: Activity)

    fun watchResult(): Completable
}

class AuthRepositoryImpl @Inject constructor(
    private val auth: Auth,
    private val preference: AppPreference
) : AuthRepository {

    private val error = BehaviorSubject.create<Optional<Exception>>()

    override fun authenticate(authCallbackActivity: Activity) {
        auth.authenticate(
            activity = authCallbackActivity,
            onSuccess = {
                preference.save("token", it.accessToken)
                error.onNext(Optional.empty())
            },
            onFailure = {
                error.onNext(Optional.of(value = it))
            }
        )
    }

    override fun watchResult(): Completable {
        return error.flatMapCompletable {
            if (it.value == null)
                Completable.complete()
            else
                Completable.error(it.value)
        }
    }
}
