package com.example.androidtrivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
//import com.example.android.navigation.databinding.FragmentGameWonBinding
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

        binding.nextMatchButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameWonFragment2_to_gameFragment3))
//        binding.nextMatchButton.setOnClickListener { view :View -> this.findNavController().navigate(R.id.action_gameWonFragment2_to_gameFragment3) }
            return binding.root
    }
}