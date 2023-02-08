package com.example.androidtrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.androidtrivia.databinding.FragmentTitleBinding


class titleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)


        binding.playButton.setOnClickListener (
                Navigation.createNavigateOnClickListener(R.id.action_titleFragment2_to_gameFragment3)
        )



        return binding.root
    }


}