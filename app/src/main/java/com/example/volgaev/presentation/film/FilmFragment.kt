package com.example.volgaev.presentation.film

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.volgaev.R
import com.example.volgaev.databinding.FragmentFilmBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmFragment : Fragment(R.layout.fragment_film) {

    private val binding: FragmentFilmBinding by viewBinding (FragmentFilmBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}