package com.gado.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gado.entity.database.respons.MovieResponseResult
import com.gado.movieapp.R
import com.gado.movieapp.databinding.MovieListRowBinding

class MovieAdapter(private val listener: ClickListener) :
    PagedListAdapter<MovieResponseResult, MovieAdapter.ViewHolder>(
        USER_COMPARATOR
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(it, listener) }
    }


    class ViewHolder(private val binding: MovieListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    DataBindingUtil
                        .inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.movie_list_row,
                            parent,
                            false
                        )
                )
            }
        }

        fun bind(movie: MovieResponseResult, listener: ClickListener) {
            binding.clickListener = listener
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<MovieResponseResult>() {
            override fun areItemsTheSame(
                oldItem: MovieResponseResult,
                newItem: MovieResponseResult
            ): Boolean =
                newItem.id == oldItem.id

            override fun areContentsTheSame(
                oldItem: MovieResponseResult,
                newItem: MovieResponseResult
            ): Boolean =
                newItem == oldItem
        }
    }

    interface ClickListener {
        fun onItemClick(v: View, movie: MovieResponseResult)
    }
}



