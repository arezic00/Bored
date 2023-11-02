package com.example.bored

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance  {
    val api : RandomActivityApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.boredapi.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RandomActivityApi::class.java)
    }
}