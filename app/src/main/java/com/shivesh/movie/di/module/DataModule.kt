package com.shivesh.movie.di.module

import com.shivesh.movie.data.database.LocalDataImpl
import com.shivesh.movie.data.network.RemoteDataImpl
import com.shivesh.movie.data.repository.LocalData
import com.shivesh.movie.data.repository.RemoteData
import com.shivesh.movie.di.scope.FragmentScope
import dagger.Binds
import dagger.Module

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

@Module
interface DataModule{

    @Binds
    @FragmentScope
    fun bindLocalData (localData : LocalDataImpl) : LocalData

    @Binds
    @FragmentScope
    fun bindRemoteData (remoteData : RemoteDataImpl) : RemoteData

}