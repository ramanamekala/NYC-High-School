package com.example.nychighschools.model.data

import com.example.nychighschools.model.api.RetrofitInstance

class SchoolRepository {

    private val apiService = RetrofitInstance.apiService

    suspend fun getSchoolsInfo(): List<HighSchoolModel> {
        return apiService.getSchoolsInfo()
    }

}