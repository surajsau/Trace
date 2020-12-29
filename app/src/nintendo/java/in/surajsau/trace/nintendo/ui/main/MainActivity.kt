package `in`.surajsau.trace.nintendo.ui.main

import `in`.surajsau.trace.R
import `in`.surajsau.trace.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val pagerAdapter by lazy { MainActivityPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.pager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            tab.text = TabItem.tabAt(position = position).title
        }.attach()
    }
}
