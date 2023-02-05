package com.example.volgaev.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.volgaev.R
import com.example.volgaev.data.database.models.Film
import com.example.volgaev.data.database.models.ShortFilm

class MainAdapter(var onClick:(Film)->Unit): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var listFilms: List<ShortFilm> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.model_of_list_film, parent, false)
        return MainViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentElement = listFilms[position]

        //holder.name.text = currentElement.na
        //holder.miniDescription.text = currentElement.description

    }

    override fun getItemCount(): Int {
        return listFilms.size
    }

    class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val name: TextView = itemView.findViewById(R.id.film_name)
        val miniDescription: TextView = itemView.findViewById(R.id.film_mini_description)
        val poster: ImageView = itemView.findViewById(R.id.film_poster)
        val starButton: ImageButton = itemView.findViewById(R.id.film_is_favourite)
        val layout: ConstraintLayout = itemView.findViewById(R.id.film_layout)
    }
}