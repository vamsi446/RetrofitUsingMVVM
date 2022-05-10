package com.cg.androidretrofit

data class Movie(val id:Int,
                 val overview:String,
                 val poster_path:String,
                 val release_date:String,
                 val title:String,
                 val vote_average:Double,
                 val vote_count:Int)

data class PopularMovies(val results: List<Movie>)
