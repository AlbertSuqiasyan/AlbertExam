package com.example.exam.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.databinding.ListItemResponseUserBinding
import com.example.exam.userData.Response
import com.squareup.picasso.Picasso

class ViewHolder private constructor(private val binding: ListItemResponseUserBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        item: Response
    ) {
        binding.rvtvId.text = item.id.toString()
        binding.rvtvTitle.text = item.title
        Picasso.with(itemView.context)
            .load(item.url)
            .into(binding.rvivImage)
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemResponseUserBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }
    }
}