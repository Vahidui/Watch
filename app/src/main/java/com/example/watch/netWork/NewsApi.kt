package com.example.watch.netWork

import com.example.watch.dto.post_model.Post_Model
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {
    @GET("posts")
    suspend fun getNewsPost(): Response<ArrayList<Post_Model>>

}