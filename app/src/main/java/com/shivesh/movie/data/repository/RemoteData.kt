package com.shivesh.movie.data.repository

import com.shivesh.movie.data.MovieData
import com.shivesh.movie.domain.networkstate.LoadingStatus
import java.util.*

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

// This interface is in accordance to Dependency Inversion Principle by separating the higher
// repository class from lower network class.
interface RemoteData {
    fun fetchItems(fetchDate : Date,
                   onSuccess: (movies : List<MovieData>) -> Unit,
                   onStatus: (status : LoadingStatus) -> Unit)
}