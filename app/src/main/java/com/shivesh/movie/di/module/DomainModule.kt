package com.shivesh.movie.di.module

import com.shivesh.movie.data.repository.MovieDetailRepositoryImpl
import com.shivesh.movie.data.repository.MovieListRepositoryImpl
import com.shivesh.movie.di.scope.FragmentScope
import com.shivesh.movie.domain.moviedetail.MovieDetailRepository
import com.shivesh.movie.domain.movielist.MovieListRepository
import dagger.Binds
import dagger.Module

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

@Module
interface DomainModule{

    @Binds
    @FragmentScope
    fun bindMovieListRepository(movieListRepository : MovieListRepositoryImpl) : MovieListRepository

    @Binds
    @FragmentScope
    fun bindMovieDetailRepository(movieDetailRepository : MovieDetailRepositoryImpl) : MovieDetailRepository
}