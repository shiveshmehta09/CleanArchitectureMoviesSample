package com.shivesh.movie.data.database

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.shivesh.movie.domain.entity.MoviePoster
import com.shivesh.movie.domain.networkstate.BoundaryState
import timber.log.Timber
import java.util.*

/**
 * Created by Shivesh K Mehta on 18-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */
class MovieBoundaryCallback : PagedList.BoundaryCallback<MoviePoster>() {

    private val _boundaryState = MutableLiveData<BoundaryState<Date>>()
    val boundaryState : LiveData<BoundaryState<Date>>
        get() = _boundaryState

    companion object {
        const val DATABASE_PAGE_SIZE = 15
    }

    override fun onItemAtFrontLoaded(itemAtFront: MoviePoster) {
        Timber.d(
            "onItemAtFrontLoaded %d %s %s ", itemAtFront.id,
            itemAtFront.title, itemAtFront.hashCode()
        )
        _boundaryState.value = BoundaryState.itemLoadedAtTop(itemAtFront.releaseDate)
    }

    override fun onZeroItemsLoaded() {
        Timber.d("onZeroItemsLoaded")
        _boundaryState.value = BoundaryState.zeroItemsLoaded(Date())
    }

    override fun onItemAtEndLoaded(itemAtEnd: MoviePoster) {
        Timber.d(
            "onItemAtFrontLoaded %d %s %s ", itemAtEnd.id,
            itemAtEnd.title, itemAtEnd.hashCode()
        )
        _boundaryState.value = BoundaryState.itemLoadedAtBottom(itemAtEnd.releaseDate)
    }

    fun refresh(){
        Timber.d("refresh")
        _boundaryState.value = BoundaryState.zeroItemsLoaded(Date())
    }

}