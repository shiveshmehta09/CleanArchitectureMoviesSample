package com.shivesh.movie.di.component

import com.shivesh.movie.di.module.DataModule
import com.shivesh.movie.di.module.DomainModule
import com.shivesh.movie.di.scope.FragmentScope
import com.shivesh.movie.ui.moviedetail.MovieDetailFragment
import com.shivesh.movie.ui.movielist.MovieListFragment
import dagger.Subcomponent

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

@Subcomponent(modules = [DataModule::class, DomainModule::class])
@FragmentScope
interface FragmentComponent{
    fun inject(movieListFragment: MovieListFragment)
    fun inject(movieDetailFragment: MovieDetailFragment)
}