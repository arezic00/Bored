package com.example.bored

import retrofit2.Response
import retrofit2.http.GET

interface RandomActivityApi {
    @GET("/api/activity")
    suspend fun getRandomActivity() : Response<RandomActivity>
}