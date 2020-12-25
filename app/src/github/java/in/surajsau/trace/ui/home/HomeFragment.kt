package `in`.surajsau.trace.ui.home

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.Fragment
import `in`.surajsau.trace.databinding.FragmentHomeBinding
import `in`.surajsau.trace.ui.main.MainActivityViewModel
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment<FragmentHomeBinding>() {

    private val viewModel: HomeFragmentViewModel by viewModels()

    private val activityViewModel: MainActivityViewModel by activityViewModels()

    override val layoutId: Int
        get() = R.layout.fragment_home
}
