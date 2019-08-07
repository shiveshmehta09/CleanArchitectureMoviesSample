package com.shivesh.movie.ui.movielist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shivesh.movie.domain.ResourceUrl
import com.shivesh.movie.domain.entity.MoviePoster
import com.shivesh.movie.ui.getReadable
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.*
import shiveshmehta.android.movie.R

/**
 * Created by Shivesh K Mehta on 21-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieListViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(movie: MoviePoster?, listener: (Long) -> Unit) {
        if (movie != null) {
            with(movie) {
                moviePoster.contentDescription = title
                Picasso.get().load(ResourceUrl.getPosterUrl(posterPath))
                    .placeholder(R.drawable.poster_placeholder).into(moviePoster)
                val rating = voteAverage / 10 * 5
                ratingBar.rating = rating
                movieReleaseDate.text = releaseDate.getReadable()
                itemView.setOnClickListener { listener.invoke(this.id) }
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieListViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
            return MovieListViewHolder(view)
        }
    }
}