package `in`.surajsau.trace.ui.profile

import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.androidx.disposeBy
import `in`.surajsau.trace.domain.model.Repo
import `in`.surajsau.trace.domain.usecase.WatchPinnedRepos
import `in`.surajsau.trace.domain.usecase.WatchUser
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

class ProfileFragmentViewModel @ViewModelInject constructor(
    private val refreshProfile: RefreshProfile,
    private val watchUser: WatchUser,
    private val watchPinnedRepos: WatchPinnedRepos,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val model = MutableLiveData<ProfileFragmentModel>()

    val pinnedRepos = MutableLiveData<List<Repo>>()

    fun onViewCreated() {
        refreshProfile.invoke()
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({}, { it.printStackTrace() })
            .disposeBy(disposables)

        watchUser.invoke()
            .map { it.toProfileFragmentModel() }
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({ model.value = it }, { it.printStackTrace() })
            .disposeBy(disposables)

        watchPinnedRepos.invoke()
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({ pinnedRepos.value = it }, { it.printStackTrace() })
            .disposeBy(disposables)
    }

    fun refresh() {
        refreshProfile.invoke()
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
