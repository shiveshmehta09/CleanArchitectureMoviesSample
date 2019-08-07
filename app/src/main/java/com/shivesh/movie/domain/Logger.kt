package com.shivesh.movie.domain

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */
//interface to remove domain layer dependency on Timber library
interface Logger {
    fun d(msg: String, vararg values: Any?)
}