package com.shivesh.movie.data.database

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.shivesh.movie.data.MovieData
import com.shivesh.movie.domain.entity.Movie
import com.shivesh.movie.domain.entity.MoviePoster

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

@Dao
interface MovieDao {

    @Query("SELECT id, title, posterPath, releaseDate, voteAverage  FROM movies ORDER BY releaseDate DESC, title ASC")
    fun getDataSourcefactory(): DataSource.Factory<Int, MoviePoster>

    @Query("SELECT * FROM movies WHERE id= :id")
    fun getMovie(id: Long) : LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieData>)

    @Query("DELETE FROM movies")
    fun deleteMovies()
}