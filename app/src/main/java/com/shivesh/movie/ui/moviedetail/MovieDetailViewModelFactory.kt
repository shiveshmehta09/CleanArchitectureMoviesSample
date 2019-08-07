package com.shivesh.movie.ui.moviedetail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.shivesh.movie.domain.moviedetail.MovieDetailUseCase
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieDetailViewModelFactory @Inject constructor(private val movieDetailUseCase: MovieDetailUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieDetailViewModel(movieDetailUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}