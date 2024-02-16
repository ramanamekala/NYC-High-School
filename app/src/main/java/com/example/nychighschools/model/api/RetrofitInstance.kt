package com.example.nychighschools.model.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://data.cityofnewyork.us/resource/"


    private val retrofit: Retrofit by lazy {


        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)

        val gson = GsonBuilder()
            .create()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }


}