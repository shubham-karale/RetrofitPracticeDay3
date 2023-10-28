package com.example.retrofitpracticeday3

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("comments")
    fun getComments() : Call<DataClass>

}