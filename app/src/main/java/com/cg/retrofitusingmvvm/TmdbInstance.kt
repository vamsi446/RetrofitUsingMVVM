package com.cg.retrofitusingmvvm

import com.cg.androidretrofit.TmdbInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TmdbInstance {
    companion object{
        val BASE_URL="https://api.themoviedb.org/"
        fun getRetrofitInstance(): Retrofit {
            val builder= Retrofit.Builder()
            builder.addConverterFactory(GsonConverterFactory.create())
            builder.baseUrl(BASE_URL)
            val retrofit=builder.build()
            return retrofit

        }
    }
}