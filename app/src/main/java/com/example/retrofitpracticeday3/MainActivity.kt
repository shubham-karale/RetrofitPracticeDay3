package com.example.retrofitpracticeday3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    lateinit var adapter:CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recylerView)

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getComments()

        retrofitData.enqueue(object : Callback<DataClass?> {
            override fun onResponse(call: Call<DataClass?>, response: Response<DataClass?>) {
               val responseBody = response.body()!!
                var commentsList = responseBody

                adapter = CommentsAdapter(this@MainActivity,commentsList)

                recyclerView.adapter = adapter

                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                Log.d("MainActivity","onResponse: "+commentsList)

            }

            override fun onFailure(call: Call<DataClass?>, t: Throwable) {
               Log.d("MainActivity","onFailure: "+t.message)
            }
        })


    }
}