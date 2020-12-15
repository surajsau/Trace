package `in`.surajsau.trace.ui.login

import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.domain.usecase.Authenticate
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class LoginActivityViewModel @ViewModelInject constructor(
    private val authenticate: Authenticate,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    fun onViewCreated() {
    }
}
