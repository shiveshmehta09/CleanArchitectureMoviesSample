package com.shivesh.movie.ui.moviedetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.shivesh.movie.domain.entity.Movie
import com.shivesh.movie.domain.moviedetail.MovieDetailUseCase
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieDetailViewModel @Inject constructor(private val movieDetailUseCase : MovieDetailUseCase) : ViewModel() {
    private val _movieId = MutableLiveData<Long>()

    val movie : LiveData<Movie> = Transformations
        .switchMap(_movieId) { id ->
            movieDetailUseCase.getMovie(id)
        }

    fun setMovieId(id : Long){
        // We need the movie data only once. If it's already there no need to set id again as it
        // will force to get the data again fron the database. This check is helpful in case of
        // configuration changes as we call setMovieId from fragment.
        if(_movieId.value != id) {
            _movieId.value = id
        }
    }
}