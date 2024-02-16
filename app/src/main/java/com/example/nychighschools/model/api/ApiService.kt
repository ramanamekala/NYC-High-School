package com.example.nychighschools.model.api

import com.example.nychighschools.model.data.HighSchoolModel
import retrofit2.http.GET

interface ApiService {

    @GET("s3k6-pzi2.json")
    suspend fun getSchoolsInfo(): List<HighSchoolModel>
}