package `in`.surajsau.trace.ui.login

import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.androidx.disposeBy
import `in`.surajsau.trace.domain.usecase.Authenticate
import `in`.surajsau.trace.domain.usecase.WatchAuthentication
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

class LoginActivityViewModel @ViewModelInject constructor(
    private val authenticate: Authenticate,
    private val watchAuthentication: WatchAuthentication,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    fun onViewCreated() {
        watchAuthentication.invoke()
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({}, {})
            .disposeBy(disposables)
    }

    fun onLoginClicked(activity: LoginActivity) {
        authenticate.invoke(activity)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    private val disposables = CompositeDisposable()
}
