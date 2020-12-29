package `in`.surajsau.trace.nintendo.ui.new

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.dp
import `in`.surajsau.trace.androidx.setCornerRadius
import `in`.surajsau.trace.databinding.ViewGameBinding
import `in`.surajsau.trace.nintendo.domain.models.Content
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import kotlin.properties.Delegates

class NewGamesAdapter constructor(
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<NewGamesAdapter.ViewHolder>() {

    var items: List<Content> by Delegates.observable(emptyList()) { _, oldList, newList ->
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = oldList.size

            override fun getNewListSize(): Int = newList.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].id == newList[newItemPosition].id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].formalName == newList[newItemPosition].formalName
            }
        }).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewGameBinding>(
            LayoutInflater.from(parent.context),
            R.layout.view_game,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ViewGameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Content) {
            binding.contentTitle.text = item.formalName
            binding.contentImage.setCornerRadius(corner = 8.dp)

            imageLoader.enqueue(request = ImageRequest.Builder(itemView.context)
                .data(data = item.heroBannerUrl)
                .target(binding.contentImage)
                .build()
            )
        }
    }
}
