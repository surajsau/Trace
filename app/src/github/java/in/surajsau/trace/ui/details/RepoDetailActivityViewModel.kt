package `in`.surajsau.trace.ui.details

import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.androidx.disposeBy
import `in`.surajsau.trace.domain.model.Repo
import `in`.surajsau.trace.domain.usecase.FetchRepoDetail
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

class RepoDetailActivityViewModel @ViewModelInject constructor(
    private val fetchRepoDetail: FetchRepoDetail,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val repo = MutableLiveData<Repo>()

    fun onCreate(repoApiUrl: String) {
        fetchRepoDetail.invoke(repoApiUrl = repoApiUrl)
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({ repo.value = it }, {})
            .disposeBy(disposables)
    }

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
