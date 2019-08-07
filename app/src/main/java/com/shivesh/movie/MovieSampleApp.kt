package com.shivesh.movie

import android.app.Application
import com.shivesh.movie.di.component.ApplicationComponent
import com.shivesh.movie.di.component.DaggerApplicationComponent
import shiveshmehta.android.movie.BuildConfig
import timber.log.Timber

/**
 * Created by Shivesh K Mehta on 20-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class MovieSampleApp : Application() {

    private val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(PrefixDebugTree())
        }
    }

    companion object {
        lateinit var instance: MovieSampleApp
            private set
    }

    fun getApplicationComponent(): ApplicationComponent = appComponent
}
