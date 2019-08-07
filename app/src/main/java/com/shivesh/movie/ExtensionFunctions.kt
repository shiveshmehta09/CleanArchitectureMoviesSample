package com.shivesh.movie

import android.content.Context
import android.widget.Toast

/**
 * Created by Shivesh K Mehta on 20-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

