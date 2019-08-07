package com.shivesh.movie.data.network

import com.shivesh.movie.data.MovieData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

interface MovieService {

    @GET("discover/movie?certification_country=US&adult=false&with_original_language=en&sort_by=primary_release_date.desc")
    fun getMovies(
        @Query("primary_release_date.lte") releaseDate: String
    ): Call<List<MovieData>>
}
