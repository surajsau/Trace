package `in`.surajsau.trace.ui.profile

import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.androidx.disposeBy
import `in`.surajsau.trace.domain.usecase.FetchUser
import `in`.surajsau.trace.domain.usecase.WatchUser
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class ProfileFragmentViewModel @ViewModelInject constructor(
    private val fetchUser: FetchUser,
    private val watchUser: WatchUser,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val model = MutableLiveData<ProfileFragmentModel>()

    fun onViewCreated() {
        fetchUser.invoke()
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({}, {})
            .disposeBy(disposables)

        watchUser.invoke()
            .map { it.toProfileFragmentModel() }
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({ model.value = it }, {})
            .disposeBy(disposables)
    }

    fun refresh() {
        fetchUser.invoke()
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({}, {})
            .disposeBy(disposables)
    }

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
