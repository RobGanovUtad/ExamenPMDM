package com.example.examenextraordinariapmdm.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examenextraordinariapmdm.data.model.Personaje
import com.example.examenextraordinariapmdm.R
import com.example.examenextraordinariapmdm.databinding.ItemPersonajeBinding

class PersonajeAdapter (
    private val onClickPersonaje: (Personaje) -> Unit,
) : ListAdapter<Personaje, PersonajeAdapter.PersonajeViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val binding = ItemPersonajeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonajeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val personaje = getItem(position)
        holder.bind(personaje)
    }

    inner class PersonajeViewHolder(private val binding: ItemPersonajeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(personaje: Personaje) {
            binding.apply {
                Glide.with(root.context).load(personaje.image).into(imageView)
                textViewName.text = personaje.name
                root.setOnClickListener { onClickPersonaje(personaje) }
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Personaje>() {
        override fun areItemsTheSame(oldItem: Personaje, newItem: Personaje): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Personaje, newItem: Personaje): Boolean {
            return oldItem == newItem
        }
    }
}