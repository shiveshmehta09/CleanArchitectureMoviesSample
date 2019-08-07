package com.shivesh.movie.data.network

import com.shivesh.movie.data.MovieData
import com.shivesh.movie.data.getSimple
import com.shivesh.movie.data.repository.RemoteData
import com.shivesh.movie.domain.networkstate.ErrorCode
import com.shivesh.movie.domain.networkstate.LoadingStatus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.io.IOException
import java.util.*
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 15-07-2019.
 * Contact: shiveshmehta09@gmail.com
 */

class RemoteDataImpl @Inject constructor(private val movieService: MovieService) :
    RemoteData {
    override fun fetchItems(
        fetchDate: Date,
        onSuccess: (movies: List<MovieData>) -> Unit,
        onStatus: (status: LoadingStatus) -> Unit
    ) {
        val call = movieService.getMovies(fetchDate.getSimple())
        call.enqueue(object : Callback<List<MovieData>?> {
            override fun onResponse(call: Call<List<MovieData>?>?, response: Response<List<MovieData>?>?) {
                if (response != null) {
                    if (response.body()?.size == 0) {
                        onStatus(
                            LoadingStatus.error(
                            ErrorCode.NO_DATA))
                    } else {
                        response.body()?.let {
                            onSuccess(it)
                            Timber.d("fetchMore saved: %s", fetchDate)
                        }
                        onStatus(LoadingStatus.success())
                    }
                }
            }

            override fun onFailure(call: Call<List<MovieData>?>?, t: Throwable?) {
                if (t is IOException) {
                    onStatus(
                        LoadingStatus.error(
                        ErrorCode.NETWORK_ERROR, t.message))
                } else {
                    onStatus(
                        LoadingStatus.error(
                        ErrorCode.UNKNOWN_ERROR, null))
                }
            }
        })
    }
}