package `in`.surajsau.trace.playstore.ui.search

import `in`.surajsau.trace.R
import `in`.surajsau.trace.databinding.ActivitySearchBinding
import `in`.surajsau.trace.playstore.ui.main.MainActivityTabs
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val viewModel: SearchActivityViewModel by viewModels()

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        viewModel.searchTextHint.observe(this, Observer { binding.searchText.hint = it })

        viewModel.finishActivity.observe(
            this,
            Observer {
                setResult(it)
                finish()
            }
        )

        viewModel.onCreate(intent.getSerializableExtra("tab") as? MainActivityTabs)
    }

    companion object {
        fun createIntent(context: Context, tab: MainActivityTabs): Intent {
            return Intent(context, SearchActivity::class.java).apply {
                putExtra("tab", tab)
            }
        }
    }
}
