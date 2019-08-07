package com.shivesh.movie.di.module

import com.shivesh.movie.TimberLogger
import com.shivesh.movie.di.scope.ApplicationScope
import com.shivesh.movie.domain.Logger
import dagger.Binds
import dagger.Module

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

@Module(includes = [ApplicationModule.LoggerModule::class])
class ApplicationModule() {
    @Module
    interface LoggerModule{
        @Binds
        @ApplicationScope
        fun bindLogger(loagger : TimberLogger) : Logger
    }
}