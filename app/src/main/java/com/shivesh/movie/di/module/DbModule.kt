package com.shivesh.movie.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.shivesh.movie.data.database.MovieDb
import com.shivesh.movie.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

@Module
class DbModule(){

    @Provides
    @ApplicationScope
    fun provideMovieDb(application: Application) =
        Room.databaseBuilder(
            application,
            MovieDb::class.java, "movie.db"
        ).build()

    @Provides
    @ApplicationScope
    fun provideMovieDao(movieDb: MovieDb) = movieDb.movieDao()
}