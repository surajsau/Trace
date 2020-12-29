package `in`.surajsau.trace.nintendo.ui.main

import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.androidx.disposeBy
import `in`.surajsau.trace.nintendo.domain.models.Content
import `in`.surajsau.trace.nintendo.domain.usecase.FetchDiscountedGames
import `in`.surajsau.trace.nintendo.domain.usecase.FetchNewGames
import `in`.surajsau.trace.nintendo.domain.usecase.FetchRankGames
import `in`.surajsau.trace.nintendo.domain.usecase.WatchGames
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivityViewModel @ViewModelInject constructor(
    private val fetchNewGames: FetchNewGames,
    private val fetchRankGames: FetchRankGames,
    private val fetchDiscountedGames: FetchDiscountedGames,
    private val watchGames: WatchGames,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val games = MutableLiveData<List<Content>>()

    fun onViewCreated() {

        fetchNewGames.invoke()
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({}, { it.printStackTrace() })
            .disposeBy(disposables)

        watchGames.invoke()
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({ games.value = it }, { it.printStackTrace() })
    }

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
