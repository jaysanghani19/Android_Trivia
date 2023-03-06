package com.example.androidtrivia

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.androidtrivia.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false
        )

//      setting up that visibility of optionmenu to True
        setHasOptionsMenu(true)
//        Navigating to titleFragment
        binding.nextMatchButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                GameWonFragmentDirections.actionGameWonFragment2ToGameFragment3()
            )
        )
        return binding.root
    }

    //  making and returning intent for sharing
    private fun getShareIntent(): Intent {

        // Argument Received From GameFragment
        var args = GameWonFragmentArgs.fromBundle(requireArguments())
        return ShareCompat.IntentBuilder.from(requireActivity()).setText(
            getString(
                R.string.share_success_text,
                args.numCorrect,
                args.numAnswered
            )
        ).setType("text/text").intent
    }

    //  using function we're sharing the intent that we've created
    private fun shareIntent() {
        try {
            startActivity(getShareIntent())
        } catch (ex: android.content.ActivityNotFoundException) {

        }
    }

    //  enabling the showing optionmenu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)

//        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
//            menu.findItem(R.id.share).isVisible = false
//        }
    }

    //  selecting the which option to show
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareIntent()
        }
        return super.onOptionsItemSelected(item)
    }
}