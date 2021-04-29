package `in`.surajsau.trace.playstore.ui.search

import `in`.surajsau.trace.androidx.ResourceProvider
import `in`.surajsau.trace.playstore.ui.main.MainActivityTabs
import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import javax.inject.Inject

class SearchActivityViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider
) : ViewModel() {

    private val _tab = MutableLiveData<MainActivityTabs>()

    val searchTextHint = _tab.map { resourceProvider.getString(it.searchCardTextRes) }

    val finishActivity = MutableLiveData<Int>()

    fun onCreate(tab: MainActivityTabs?) {
        if (tab == null) {
            finishActivity.value = Activity.RESULT_CANCELED
            return
        }
        _tab.value = tab!!
    }
}
