package `in`.surajsau.trace.playstore.ui.main

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.ResourceProvider
import android.view.MenuItem
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainActivityViewModel @ViewModelInject constructor(
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val _tab = MutableLiveData<MainActivityTabs>(MainActivityTabs.GameTabs)

    val tabs = _tab.map { it.tabs }
    val tabColor = _tab.map { resourceProvider.getColor(it.colorRes) }
    val searchCardText = _tab.map { resourceProvider.getString(it.searchCardTextRes) }

    val openSearchActivity = MutableLiveData<MainActivityTabs>()

    fun onCreate() {
    }

    fun onTabSelected(it: MenuItem) {
        when (it.itemId) {
            R.id.action_apps -> {
                _tab.value = MainActivityTabs.AppsTabs
            }

            R.id.action_games -> {
                _tab.value = MainActivityTabs.GameTabs
            }

            R.id.action_books -> {
                _tab.value = MainActivityTabs.BooksTabs
            }

            R.id.action_movies -> {
                _tab.value = MainActivityTabs.MoviesTabs
            }
        }
    }

    fun onSearchCardClicked() {
        val currentTab = _tab.value ?: return
        openSearchActivity.value = currentTab
    }
}
