package com.example.watch.netWork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NewsApiObject {
    val newsObject : NewsApi by lazy {
        Retrofit.Builder().baseUrl("https://mockend.com/mahdico/rubinnews/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

}