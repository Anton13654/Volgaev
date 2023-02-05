package com.example.volgaev.presentation.film

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.volgaev.R
import com.example.volgaev.databinding.FragmentFilmBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FilmFragment : Fragment(R.layout.fragment_film) {

    private val binding: FragmentFilmBinding by viewBinding (FragmentFilmBinding::bind)
    private val args by navArgs<FilmFragmentArgs>()
    private val viewModel: FilmViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        viewModel.getFilm(args.id)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.film.collect{
                if(it!=null) {
                    binding.fullName.text = it.name
                    binding.fullCountry.text = it.country
                    binding.fullDescription.text = it.description
                    binding.fullYear.text = it.year
                    Picasso.get()
                        .load(it.poster)
                        .into(binding.fullImage);
                }
            }
        }

    }
}