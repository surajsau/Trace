package `in`.surajsau.trace.ui.notifications

import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.androidx.disposeBy
import `in`.surajsau.trace.domain.usecase.FetchReadNotifications
import `in`.surajsau.trace.domain.usecase.FetchUnreadNotifications
import `in`.surajsau.trace.domain.usecase.WatchNotifications
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

class NotificationFragmentViewModel @ViewModelInject constructor(
    private val fetchReadNotifications: FetchReadNotifications,
    private val fetchUnreadNotifications: FetchUnreadNotifications,
    private val watchNotifications: WatchNotifications,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val notifications = watchNotifications.invoke()

    fun onViewCreated() {

        fetchUnreadNotifications.invoke()
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe(
                {}, { it.printStackTrace() }
            )
            .disposeBy(disposables)
    }

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
