package com.shivesh.movie.ui.movielist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.shivesh.movie.domain.movielist.MovieListUseCase
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 21-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieListViewModelFactory @Inject constructor(private val movieListUseCase: MovieListUseCase) : ViewModelProvider.Factory {
    init{
        Timber.d("init")
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieListViewModel(movieListUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}