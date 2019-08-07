package com.shivesh.movie.data.repository

import android.arch.lifecycle.LiveData
import com.shivesh.movie.domain.entity.Movie
import com.shivesh.movie.domain.moviedetail.MovieDetailRepository
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieDetailRepositoryImpl @Inject constructor(
    private val localData: LocalData
) : MovieDetailRepository {
    override
    fun getMovie(id : Long): LiveData<Movie> {
        return localData.getMovie(id)
    }
}
