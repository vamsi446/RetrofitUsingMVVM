package com.cg.retrofitusingmvvm

import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cg.androidretrofit.Movie


class MovieAdapter():RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList:List<Movie>?=null
    fun setMovieList(movieList: List<Movie>?)
    {
        this.movieList=movieList
    }
    class ViewHolder(view:View):RecyclerView.ViewHolder(view)
    {
        val posterIV=view.findViewById<ImageView>(R.id.imageView)
        val titleT=view.findViewById<TextView>(R.id.titleT)
        val overViewT=view.findViewById<TextView>(R.id.overViewT)
        val ratingT=view.findViewById<TextView>(R.id.ratingT)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.item_movie_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie=movieList?.get(position)!!
        holder.titleT.setText(movie.title)
        holder.overViewT.setText(movie.overview)
        holder.ratingT.setText("Rating : ${movie.vote_average}")

        val imageUrl="https://image.tmdb.org/t/p/w500${movie.poster_path}"


//        val req=TmdbInterface.getInstance().getImage(imageUrl)
//        req.enqueue(object : Callback<ResponseBody>{
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//            if(response.isSuccessful)
//            {
//                val bytes=response.body()?.bytes()
//                val bitmap=BitmapFactory.decodeByteArray(bytes,0,bytes?.size?:0)
//                holder.posterIV.setImageBitmap(bitmap)
//
//            }
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                Log.d("MovieAdapter","Failed to Download : ${t.message}")
//
//            }
//
//        })

        Glide.with(holder.itemView.context).load(Uri.parse(imageUrl)).into(holder.posterIV)



    }

    override fun getItemCount(): Int {
        if(movieList==null)
            return 0
        else
            return movieList?.size!!
    }


}