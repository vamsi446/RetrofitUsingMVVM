package com.cg.androidretrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface TmdbInterface {
    @GET("3/movie/popular")
    fun getMovies(@Query("api_key") key:String):Call<PopularMovies>
    @GET
    fun getImage(@Url url:String):Call<ResponseBody>


}