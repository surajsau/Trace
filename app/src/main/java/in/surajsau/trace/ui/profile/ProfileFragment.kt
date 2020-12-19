package `in`.surajsau.trace.ui.profile

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.Fragment
import `in`.surajsau.trace.androidx.dp
import `in`.surajsau.trace.databinding.FragmentProfileBinding
import android.graphics.Outline
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import coil.Coil
import coil.ImageLoader
import coil.request.ImageRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment<FragmentProfileBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_profile

    private val viewModel: ProfileFragmentViewModel by viewModels()

    private val imageLoader: ImageLoader by lazy { Coil.imageLoader(requireContext()) }

    private val pinnedRepositoryAdapter: PinnedRepositoryAdapter by lazy {
        PinnedRepositoryAdapter(imageLoader = imageLoader)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileHeader.let {
            it.profilePicture.outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View?, outline: Outline?) {
                    view ?: return
                    outline?.setRoundRect(0, 0, view.width, view.height, 8.dp.value)
                }
            }
        }

        binding.pinnedRepoList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.pinnedRepoList.adapter = pinnedRepositoryAdapter

        viewModel.model.observe(
            viewLifecycleOwner,
            Observer { model ->
                binding.profileHeader.let {
                    it.profileName.text = model.profileName
                    it.profileOrganisation.text = model.profileOrganisation
                    it.profileLocation.text = model.profileLocation
                    it.profileHandle.text = model.profileHandle

                    imageLoader.enqueue(
                        request = ImageRequest.Builder(requireContext())
                            .data(data = model.profileImage)
                            .target(imageView = it.profilePicture)
                            .build()
                    )
                }
            }
        )

        viewModel.pinnedRepos.observe(
            viewLifecycleOwner,
            Observer { pinnedRepositoryAdapter.setData(items = it) }
        )

        viewModel.onViewCreated()
    }
}
