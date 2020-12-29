package `in`.surajsau.trace.nintendo.ui.new

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.Fragment
import `in`.surajsau.trace.databinding.FragmentNewGamesBinding
import `in`.surajsau.trace.nintendo.ui.main.MainActivityViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import coil.Coil
import io.reactivex.rxjava3.disposables.CompositeDisposable

class NewGamesFragment : Fragment<FragmentNewGamesBinding>() {

    private val adapter by lazy { NewGamesAdapter(imageLoader = Coil.imageLoader(requireContext())) }

    private val viewModel by activityViewModels<MainActivityViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.list.adapter = adapter

        viewModel.games.observe(
            viewLifecycleOwner,
            Observer {
                adapter.items = it
            }
        )

        viewModel.onViewCreated()
    }

    override val layoutId: Int
        get() = R.layout.fragment_new_games

    private val disposables = CompositeDisposable()

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }
}
