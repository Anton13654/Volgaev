package com.example.volgaev.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.volgaev.R
import com.example.volgaev.data.Section
import com.example.volgaev.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getListFilms()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFavourites.setOnClickListener{
            viewModel.changeList(Section.Favourites)
        }
        binding.buttonPopular.setOnClickListener{
            viewModel.changeList(Section.Popular)
        }

        val adapter = MainAdapter(){clickTime, id ->
            if (clickTime == LONG_CLICK){
                viewModel.addFavourite(id)
            }else{
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToFilmFragment(id))
            }

        }
        binding.filmsRecycler.adapter = adapter
        binding.filmsRecycler.layoutManager = LinearLayoutManager(requireContext())

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.listFilms.collect{
                if (it != null) {
                    adapter.listId = it.first
                    adapter.listFilms = it.second
                }
            }
        }


    }




}