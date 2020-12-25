package `in`.surajsau.trace.ui.new

import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.androidx.disposeBy
import `in`.surajsau.trace.domain.usecase.FetchNewGames
import `in`.surajsau.trace.domain.usecase.WatchGames
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

class NewGamesFragmentViewModel constructor(
    private val fetchNewGames: FetchNewGames,
    watchGames: WatchGames,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    val games = watchGames.invoke()

    fun onViewCreated() {

        fetchNewGames.invoke()
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe({}, { it.printStackTrace() })
            .disposeBy(disposables)
    }

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
