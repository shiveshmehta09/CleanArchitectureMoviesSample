package com.shivesh.movie.ui

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Shivesh K Mehta on 20-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

fun Date.getReadable(): String {
    val dateFormat = SimpleDateFormat("dd MMM yy", Locale.getDefault())
    return dateFormat.format(this)
}

