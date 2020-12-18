package `in`.surajsau.trace.ui.notifications

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.getImageDrawable
import `in`.surajsau.trace.databinding.ViewNotificationBinding
import `in`.surajsau.trace.domain.model.Notification
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class NotificationAdapter : PagingDataAdapter<Notification, NotificationAdapter.ViewHolder>(DiffCallback) {

    inner class ViewHolder constructor(private val binding: ViewNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: NotificationAdapterModel) {
            binding.notificationRepositoryDisplayName.text = item.repositoryDisplayName
            binding.notificationTitle.text = item.title
            binding.pullRequestIcon.setImageDrawable(
                getImageDrawable(
                    id = if (item.isMerged)
                        R.drawable.ic_pull_request_merged
                    else
                        R.drawable.ic_pull_request
                )
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)?.toAdapterModel() ?: return
        holder.onBind(item = item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewNotificationBinding =
            DataBindingUtil.inflate(inflater, R.layout.view_notification, parent, false)

        return ViewHolder(binding = binding)
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Notification>() {
            override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean {
                return oldItem.isMerged == newItem.isMerged
            }
        }
    }
}

data class NotificationAdapterModel(
    val title: String,
    val repositoryDisplayName: String,
    val isMerged: Boolean
)

fun Notification.toAdapterModel() = NotificationAdapterModel(
    title = title,
    repositoryDisplayName = "${repo.owner.handle} / ${repo.name}",
    isMerged = false
)
