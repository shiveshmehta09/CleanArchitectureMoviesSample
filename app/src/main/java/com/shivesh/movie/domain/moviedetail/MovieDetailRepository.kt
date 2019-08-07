package com.shivesh.movie.domain.moviedetail

import android.arch.lifecycle.LiveData
import com.shivesh.movie.domain.entity.Movie

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

// As we need to interact with repostiory which is in data layer. Implementing Dependency Inversion
// Principle we create an interface which concrete respository class in data layer implements.
// This way we remove any dependency on data layer from domain layer
interface MovieDetailRepository {
    fun getMovie(id : Long): LiveData<Movie>
}