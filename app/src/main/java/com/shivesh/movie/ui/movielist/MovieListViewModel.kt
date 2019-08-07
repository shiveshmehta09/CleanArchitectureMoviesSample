package com.shivesh.movie.ui.movielist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.shivesh.movie.domain.movielist.MovieListUseCase
import com.shivesh.movie.domain.networkstate.Direction
import com.shivesh.movie.domain.networkstate.LoadingStatus
import timber.log.Timber
import java.util.*
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 21-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieListViewModel @Inject constructor(private val movieListUseCase: MovieListUseCase) : ViewModel() {
    val movies = movieListUseCase.getMovies()

    //PagedList use BoundaryCallback object to send us callback about necessary events related to
    // data loading. Here we capture those events and fetch data from the network. The
    // movieListUseCase.fetchMore() function returns loading status which we observe in UI to
    // show progress bar.
    val loadingStatus : LiveData<LoadingStatus> = Transformations.switchMap(
        movieListUseCase.getBoundaryState()) {onBoundaryItemLoaded(it.itemData, it.direction)}

    private fun onBoundaryItemLoaded(itemDate: Date, direction: Direction) : LiveData<LoadingStatus> {
        Timber.d("onBoundaryItemLoaded %s %s ", itemDate, direction)
        return movieListUseCase.fetchMore(itemDate, direction)
    }

    fun refresh() {
        Timber.d("refreshing")
        movieListUseCase.refresh()
    }
}