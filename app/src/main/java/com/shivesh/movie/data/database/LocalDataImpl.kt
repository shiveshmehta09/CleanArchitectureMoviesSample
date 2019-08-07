package com.shivesh.movie.data.database

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.shivesh.movie.AppExecutors
import com.shivesh.movie.data.MovieData
import com.shivesh.movie.data.repository.LocalData
import com.shivesh.movie.domain.entity.Movie
import com.shivesh.movie.domain.entity.MoviePoster
import com.shivesh.movie.domain.networkstate.BoundaryState
import java.util.*
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */
class LocalDataImpl @Inject constructor(private val appExecutors: AppExecutors,
                                        private val movieDao: MovieDao) :
    LocalData {
    private val boundaryCallback =
        MovieBoundaryCallback()

    override fun getMovies(): LiveData<PagedList<MoviePoster>> {
        val dataSourceFactory = movieDao.getDataSourcefactory()
        return LivePagedListBuilder(dataSourceFactory, MovieBoundaryCallback.DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()
    }

    override fun getMovie(id : Long): LiveData<Movie> {
        return movieDao.getMovie(id)
    }

    override fun getBoundaryState(): LiveData<BoundaryState<Date>> {
        return boundaryCallback.boundaryState
    }

    override fun insertMovies(movies: List<MovieData>) {
        appExecutors.diskIO().execute {
            movieDao.insertMovies(movies)
        }
    }

    override fun deleteMovies() {
        movieDao.deleteMovies()
    }

    override fun refresh() {
        boundaryCallback.refresh()
    }
}