package com.example.exam.recyclerView

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.exam.userData.Response

class UserAdapter : ListAdapter<Response, ViewHolder>(UserDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun filterList(filteredList: ArrayList<Response>) {
        submitList(filteredList)
    }

}

class UserDiffCallBack : DiffUtil.ItemCallback<Response>() {
    override fun areItemsTheSame(oldItem: Response, newItem: Response): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Response, newItem: Response): Boolean {
        return oldItem == newItem
    }
}