package com.example.volgaev.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.volgaev.R
import com.example.volgaev.data.database.models.Film
import com.example.volgaev.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MainAdapter(){
            viewModel.
        }
        binding.filmsRecycler.adapter = adapter
        binding.filmsRecycler.layoutManager = LinearLayoutManager(requireContext())
        adapter.listFilms = listOf(
            Film(0, "Шерлок Холмс", 0, "Детектив"),
            Film(0, "Чебурашка", 0, "Комедия"),
            Film(0, "Тариф новогодний", 0, "Комедия"),
            Film(0, "Бетховен", 0, "Комедия"),
            Film(0, "Один дома", 0, "Комедия"),
            Film(0, "Энгри Бёрдс", 0, "Мультфильм"),
            Film(0, "Моя ужасная няня", 0, "Ужасы"),
        )

    }

}