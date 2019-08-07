package com.shivesh.movie

import com.shivesh.movie.domain.Logger
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 20-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

//Currently used only by "domain" layer classes to remove Timber dependency in domain layer
class TimberLogger @Inject constructor() : Logger{

    companion object {
        @Volatile
        private var INSTANCE: TimberLogger? = null

        fun getInstance(): TimberLogger =
            INSTANCE
                    ?: synchronized(this) {
                        INSTANCE
                                ?: buildInstance().also { INSTANCE = it }
                    }

        private fun buildInstance() = TimberLogger()
    }

    override fun d(msg : String, vararg values: Any?){
        Timber.d(msg, values)
    }

}