package com.shivesh.movie.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.shivesh.movie.data.MovieData

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

@Database(
    entities = [
        MovieData::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DbTypeConverters::class)
abstract class MovieDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}