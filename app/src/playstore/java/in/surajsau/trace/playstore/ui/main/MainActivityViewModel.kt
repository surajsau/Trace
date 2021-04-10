package `in`.surajsau.trace.playstore.ui.main

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.ResourceProvider
import android.view.MenuItem
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel @ViewModelInject constructor(
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    val tabs = MutableLiveData<MainActivityTabs>(MainActivityTabs.GameTabs)
    val tabColor = MutableLiveData<Int>()

    fun onCreate() {
    }

    fun onTabSelected(it: MenuItem) {
        when (it.itemId) {
            R.id.action_apps -> {
                tabs.value = MainActivityTabs.AppsTabs
                tabColor.value = resourceProvider.getColor(R.color.tab_apps)
            }

            R.id.action_games -> {
                tabs.postValue(MainActivityTabs.GameTabs)
                tabColor.value = resourceProvider.getColor(R.color.tab_games)
            }

            R.id.action_books -> {
                tabs.postValue(MainActivityTabs.MoviesTabs)
                tabColor.value = resourceProvider.getColor(R.color.tab_books)
            }

            R.id.action_movies -> {
                tabs.postValue(MainActivityTabs.MoviesTabs)
                tabColor.value = resourceProvider.getColor(R.color.tab_movies)
            }
        }
    }
}
