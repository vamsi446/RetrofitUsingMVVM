package com.cg.retrofitusingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rvAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var link="https://www.youtube.com/watch?v=zgiUnfaHP7A"
        val rv=findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager=LinearLayoutManager(this)
        rvAdapter=MovieAdapter()
        rv.adapter=rvAdapter
        initViewModel()


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ScreenRot","onDestroy")
    }
    private fun initViewModel()
    {
        val viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this){
            if(it!=null)
            {
                rvAdapter.setMovieList(it)
                rvAdapter.notifyDataSetChanged()
            }
            else
            {
                Toast.makeText(this,"Something went wrong... Please Check your Network!",Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.makeApiCall()
    }
}
