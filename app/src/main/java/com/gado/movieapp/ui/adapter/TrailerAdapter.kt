package com.gado.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gado.entity.database.respons.TrailerResponseResult
import com.gado.movieapp.R
import com.gado.movieapp.databinding.TrailerListRowBinding

class TrailerAdapter :
    ListAdapter<TrailerResponseResult, TrailerAdapter.ViewHolder>(
        DiffCall
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCall : DiffUtil.ItemCallback<TrailerResponseResult>() {
        override fun areItemsTheSame(
            oldItem: TrailerResponseResult,
            newItem: TrailerResponseResult
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TrailerResponseResult,
            newItem: TrailerResponseResult
        ): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(private val binding: TrailerListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    DataBindingUtil
                        .inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.trailer_list_row,
                            parent,
                            false
                        )
                )
            }
        }

        fun bind(trailer: TrailerResponseResult) {
            binding.trailer = trailer.key
//            binding.clickListener = listener
            binding.executePendingBindings()


        }
    }


}
