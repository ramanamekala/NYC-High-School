package com.example.nychighschools.model.data

import com.example.nychighschools.model.api.RetrofitInstance

class SchoolRepository {

    private val apiService = RetrofitInstance.apiService

    suspend fun getSchoolsInfo(): ArrayList<HighSchoolModel> {
        return apiService.getSchoolsInfo() as ArrayList<HighSchoolModel>
    }

}