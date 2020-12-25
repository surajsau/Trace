package `in`.surajsau.trace.ui.new

import `in`.surajsau.trace.R
import `in`.surajsau.trace.androidx.Fragment
import `in`.surajsau.trace.androidx.disposeBy
import `in`.surajsau.trace.databinding.FragmentNewGamesBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import io.reactivex.rxjava3.disposables.CompositeDisposable

class NewGamesFragment : Fragment<FragmentNewGamesBinding>() {

    private val viewModel: NewGamesFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.games
            .subscribe()
            .disposeBy(disposables)

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
