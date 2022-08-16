package com.example.watch.netWork

import com.example.watch.dto.post_model.Post_Model
import retrofit2.Response
import retrofit2.http.GET

interface Api1 {
    @GET("posts")
    suspend fun newApi():Response<ArrayList<Post_Model>>
}