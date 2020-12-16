package `in`.surajsau.trace.ui.notifications

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.Fragment
import `in`.surajsau.trace.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : Fragment<FragmentNotificationsBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_notifications
}
