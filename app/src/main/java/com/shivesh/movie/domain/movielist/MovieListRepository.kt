package com.shivesh.movie.domain.movielist

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.shivesh.movie.domain.entity.MoviePoster
import com.shivesh.movie.domain.networkstate.BoundaryState
import com.shivesh.movie.domain.networkstate.LoadingStatus
import java.util.*

/**
 * Created by Shivesh K Mehta on 18-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

// As we need to interact with repository which is in data layer. Implementing Dependency Inversion
// Principle we create an interface which concrete repository class in data layer implements.
// This way we remove any dependency on data layer from domain layer
interface MovieListRepository {
    fun getMovies(): LiveData<PagedList<MoviePoster>>
    fun getBoundaryState(): LiveData<BoundaryState<Date>>
    fun fetchMore(fetchDate: Date, predicate: (String?) -> (Boolean)) : LiveData<LoadingStatus>
    fun returnLoadingOrSuccess() : LiveData<LoadingStatus>
    fun refresh()
}