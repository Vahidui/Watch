package com.example.watch.netWork

import com.example.watch.dto.post_model.Post_Model
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

object ApiObject {
    val news: Api1 by lazy {
        Retrofit
            .Builder()
            .baseUrl("https://mockend.com/mahdico/rubinnews/")
            .build()
            .create(Api1::class.java)
    }
}