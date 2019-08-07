package com.shivesh.movie.di.component

import android.app.Application
import com.shivesh.movie.di.module.ApplicationModule
import com.shivesh.movie.di.module.DbModule
import com.shivesh.movie.di.module.RetrofitModule
import com.shivesh.movie.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

@Component(modules = [ApplicationModule::class, DbModule::class, RetrofitModule::class])
@ApplicationScope
interface ApplicationComponent{
    fun plusFragmentComponent() : FragmentComponent


    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
        @BindsInstance
        fun application(application: Application): Builder
    }

}