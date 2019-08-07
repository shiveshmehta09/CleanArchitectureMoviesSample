package com.shivesh.movie.data.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.shivesh.movie.data.MovieData
import com.shivesh.movie.domain.entity.Movie
import com.shivesh.movie.domain.entity.MoviePoster
import com.shivesh.movie.domain.networkstate.BoundaryState
import java.util.*

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

// This interface is in accordance to Dependency Inversion Principle by separating the higher
// repository class from lower database class.
interface LocalData {

    fun getMovies() : LiveData<PagedList<MoviePoster>>
    fun getBoundaryState(): LiveData<BoundaryState<Date>>
    fun insertMovies(movies: List<MovieData>)
    fun deleteMovies()
    fun refresh()

    fun getMovie(id : Long) : LiveData<Movie>
}