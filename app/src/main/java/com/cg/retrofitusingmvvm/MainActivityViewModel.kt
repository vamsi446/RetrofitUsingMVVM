package com.cg.retrofitusingmvvm

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cg.androidretrofit.Movie
import com.cg.androidretrofit.PopularMovies
import com.cg.androidretrofit.TmdbInterface
import retrofit2.Call
import retrofit2.Response
import java.util.*
import javax.security.auth.callback.Callback

class MainActivityViewModel : ViewModel() {

    var popularMoviesLiveData: MutableLiveData<List<Movie>>
    init {
        popularMoviesLiveData= MutableLiveData()

    }
    fun getLiveDataObserver() : MutableLiveData<List<Movie>> {
       return popularMoviesLiveData
    }
    fun makeApiCall()
    {
        val tmdbInstance=TmdbInstance.getRetrofitInstance()
        val retroService=tmdbInstance.create(TmdbInterface::class.java)
        //call

        val key="4d6c1bad3cc23c1db979b04645f03664"

        val call=retroService.getMovies(key)
        call.enqueue(PopularMoviesCallback())
    }
    inner class PopularMoviesCallback: retrofit2.Callback<PopularMovies>
    {
        override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
            if(response.isSuccessful)
            {
                val movies=response.body()
                Log.d("MainActivity"
                    ,"List: $movies")
//                Toast.makeText(this@MainActivity
//                    ,"List: $movies"
//                    ,Toast.LENGTH_SHORT).show()
                val x=movies?.results
                popularMoviesLiveData.postValue(x)

            }
        }

        override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
            popularMoviesLiveData.postValue(null)
        }

    }


}