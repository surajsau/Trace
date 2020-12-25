package `in`.surajsau.trace.ui.profile

import `in`.surajsau.trace.R
import `in`.surajsau.trace.databinding.ViewPinnedRepositoryBinding
import `in`.surajsau.trace.domain.model.Repo
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import kotlin.properties.Delegates

class PinnedRepositoryAdapter constructor(
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<PinnedRepositoryAdapter.ViewHolder>() {

    fun setData(items: List<Repo>) {
        this.items = items.map { it.toPinnedRepoModel() }
    }

    private var items: List<PinnedRepoModel> by Delegates.observable(emptyList()) { _, oldList, newList ->
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = oldList.size

            override fun getNewListSize(): Int = newList.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition].repoTitle == newList[newItemPosition].repoTitle
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val old = oldList[oldItemPosition]
                val new = newList[newItemPosition]
                return (old.starCount == new.starCount) or
                    (old.language == new.language)
            }
        }).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewPinnedRepositoryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.view_pinned_repository,
            parent,
            false
        )

        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ViewPinnedRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PinnedRepoModel) {

            binding.repoTitle.text = item.repoTitle
            binding.repoDescription.text = item.repoDescription
            binding.starCount.text = "${item.starCount}"
            binding.language.text = item.language
            binding.repoOwner.text = item.repoOwner

            imageLoader.enqueue(
                request = ImageRequest.Builder(itemView.context)
                    .data(data = item.repoOwnerImage)
                    .target(binding.repoUserImage)
                    .build()
            )
        }
    }
}

data class PinnedRepoModel(
    val repoTitle: String,
    val repoDescription: String?,
    val repoOwner: String,
    val repoOwnerImage: String,
    val language: String,
    val starCount: Int
)

fun Repo.toPinnedRepoModel() = PinnedRepoModel(
    repoTitle = name,
    repoDescription = description,
    repoOwner = owner.name,
    repoOwnerImage = owner.imageUrl,
    language = languages.joinToString { it.title },
    starCount = starCount
)
