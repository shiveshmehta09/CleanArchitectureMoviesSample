package com.shivesh.movie.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.shivesh.movie.AppExecutors
import com.shivesh.movie.domain.entity.MoviePoster
import com.shivesh.movie.domain.movielist.MovieListRepository
import com.shivesh.movie.domain.networkstate.BoundaryState
import com.shivesh.movie.domain.networkstate.LoadingStatus
import com.shivesh.movie.domain.networkstate.Status
import timber.log.Timber
import java.util.*
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieListRepositoryImpl @Inject constructor (
    private val appExecutors: AppExecutors,
    private val localData: LocalData,
    private val remoteData: RemoteData
) : MovieListRepository {
    private val loadingStatus = MutableLiveData<LoadingStatus>()

    override
    fun getMovies(): LiveData<PagedList<MoviePoster>> {
        return localData.getMovies()
    }

    override fun getBoundaryState(): LiveData<BoundaryState<Date>> {
        return localData.getBoundaryState()
    }

    override fun refresh() {
        localData.refresh()
    }

    override
    fun fetchMore(fetchDate: Date, predicate: (String?) -> (Boolean)) : LiveData<LoadingStatus> {
        if (loadingStatus.value == null || loadingStatus.value?.status != Status.LOADING) {
            loadingStatus.value = LoadingStatus.loading()
            Timber.d("fetchMore starting: %s", fetchDate)
            remoteData.fetchItems(fetchDate, { movies ->
                appExecutors.diskIO().execute {
                   localData.insertMovies(movies.filter { predicate(it.posterPath)})
                    Timber.d("fetchMore saved: %s", fetchDate)
                }
            }, {status ->
                loadingStatus.value = status
            })
        } else{
            Timber.d("fetchMore already loading %s", fetchDate)
        }
        return loadingStatus
    }

    override
    fun returnLoadingOrSuccess() : LiveData<LoadingStatus>{
        if (loadingStatus.value == null || loadingStatus.value?.status != Status.LOADING) {
            loadingStatus.value = LoadingStatus.success()
        }
        return loadingStatus
    }
}
