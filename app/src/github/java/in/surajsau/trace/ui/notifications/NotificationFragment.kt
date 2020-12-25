package `in`.surajsau.trace.ui.notifications

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.Fragment
import `in`.surajsau.trace.androidx.SchedulerProvider
import `in`.surajsau.trace.databinding.FragmentNotificationsBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@AndroidEntryPoint
class NotificationFragment : Fragment<FragmentNotificationsBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_notifications

    private val adapter: NotificationAdapter by lazy { NotificationAdapter() }

    private val viewModel: NotificationFragmentViewModel by viewModels()

    @Inject
    lateinit var schedulerProvider: SchedulerProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listView.layoutManager = LinearLayoutManager(requireContext())
        binding.listView.adapter = adapter

        viewModel.notifications
            .subscribe({ adapter.submitData(lifecycle, it) }, { it.printStackTrace() })

        viewModel.onViewCreated()
    }

    private val disposables = CompositeDisposable()

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }
}
