package com.example.nychighschools.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nychighschools.model.data.HighSchoolModel
import com.example.nychighschools.model.data.SchoolRepository
import kotlinx.coroutines.launch

class HighSchoolViewModel : ViewModel(){

    private val repository = SchoolRepository()

    private val _schoolsInfo = MutableLiveData<List<HighSchoolModel>>()
    val schoolsInfo : LiveData<List<HighSchoolModel>> = _schoolsInfo


    fun fetchSchoolsInformation() {
        viewModelScope.launch {

            try {

                val schools = repository.getSchoolsInfo()
                _schoolsInfo.value = schools
            } catch (e : Exception){
                //handle exception
                Log.d("Schools Info", " exception${e.toString()}")

            }

        }

    }


}