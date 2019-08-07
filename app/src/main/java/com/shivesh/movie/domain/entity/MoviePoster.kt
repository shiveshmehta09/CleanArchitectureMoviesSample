package com.shivesh.movie.domain.entity

import java.util.*

/**
 * Created by Shivesh K Mehta on 25-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

// On list Ui we only show posters. This entoty represent that. Overview field contains lot of data
// and by making this entity strictly for poster we are removing unnecessary overhead.
data class MoviePoster (
    val id: Long = 0,
    val title: String,
    val voteAverage: Float = 0.toFloat(),
    val posterPath: String,
    val releaseDate: Date
)
