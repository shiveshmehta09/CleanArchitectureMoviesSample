package com.shivesh.movie.domain.moviedetail

import android.arch.lifecycle.LiveData
import com.shivesh.movie.domain.Logger
import com.shivesh.movie.domain.entity.Movie
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieDetailUseCase @Inject constructor(private val repository: MovieDetailRepository, private val log : Logger){
    fun getMovie(id : Long): LiveData<Movie> {
        return repository.getMovie(id)
    }
}