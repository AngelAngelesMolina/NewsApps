package com.example.newsapp.api

import com.example.newsapp.util.Constants
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private val retrofit by lazy {
            val loggin = HttpLoggingInterceptor()
            loggin.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggin)
                .build()

            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}