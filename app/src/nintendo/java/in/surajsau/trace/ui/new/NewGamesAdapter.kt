package `in`.surajsau.trace.ui.new

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.dp
import `in`.surajsau.trace.androidx.setCornerRadius
import `in`.surajsau.trace.databinding.ViewGameBinding
import `in`.surajsau.trace.domain.models.Content
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class NewGamesAdapter : PagingDataAdapter<Content, NewGamesAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewGameBinding>(
            LayoutInflater.from(parent.context),
            R.layout.view_game,
            parent,
            false
        )
        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.bind(item = item)
    }

    inner class ViewHolder(private val binding: ViewGameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Content) {
            binding.contentTitle.text = item.formalName
            binding.contentImage.setCornerRadius(corner = 8.dp)
        }
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Content>() {
            override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
                return (oldItem.publicStatus == newItem.publicStatus) and
                    (oldItem.isNew == newItem.isNew)
            }
        }
    }
}
