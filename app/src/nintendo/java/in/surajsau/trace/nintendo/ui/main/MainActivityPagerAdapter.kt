package `in`.surajsau.trace.nintendo.ui.main

import `in`.surajsau.trace.nintendo.ui.new.NewGamesFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainActivityPagerAdapter constructor(
    activity: MainActivity
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = TabItem.values().size

    override fun createFragment(position: Int): Fragment {
        return NewGamesFragment()
    }
}
