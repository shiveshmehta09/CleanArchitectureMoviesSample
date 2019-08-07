package com.shivesh.movie.ui.movielist

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import com.shivesh.movie.domain.entity.MoviePoster

/**
 * Created by Shivesh K Mehta on 21-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieListAdapter(private val listener: (Long) -> Unit) :
    PagedListAdapter<MoviePoster, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movieItem = getItem(position)
        if (movieItem != null) {
            (holder as MovieListViewHolder).bind(movieItem, listener)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<MoviePoster>() {
            override fun areItemsTheSame(oldItem: MoviePoster, newItem: MoviePoster): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MoviePoster, newItem: MoviePoster): Boolean =
                oldItem == newItem
        }
    }
}