package `in`.surajsau.trace.ui.explore

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.Fragment
import `in`.surajsau.trace.databinding.FragmentExploreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFragment : Fragment<FragmentExploreBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_explore
}
