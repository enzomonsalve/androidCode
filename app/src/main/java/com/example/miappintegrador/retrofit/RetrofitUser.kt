package com.example.miappintegrador.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitUser {

    private val BASE_URL:String = "http://192.168.1.9:3000/api/"

    val instance: ApiService by lazy{
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(ApiService::class.java)

    }
}