package `in`.surajsau.trace.playstore.ui.main

import `in`.surajsau.trace.R
import `in`.surajsau.trace.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomTabs.inflateMenu(R.menu.menu_bottom_bar)

        binding.bottomTabs.setOnNavigationItemSelectedListener {
            viewModel.onTabSelected(it)
            true
        }

        viewModel.tabs.observe(
            this,
            Observer { tabs ->
                binding.tabs.removeAllTabs()
                tabs.forEach { tab -> binding.tabs.addTab(binding.tabs.newTab().setText(tab.title)) }
            }
        )

        viewModel.searchCardText.observe(this, Observer { binding.searchCardText.text = it })

        viewModel.tabColor.observe(
            this,
            Observer { binding.tabs.setSelectedTabIndicatorColor(it) }
        )

        viewModel.onCreate()
    }
}
