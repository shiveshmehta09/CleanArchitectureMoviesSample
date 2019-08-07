package com.shivesh.movie.data.database

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */
class DbTypeConverters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}