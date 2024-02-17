package com.example.nychighschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nychighschools.model.data.HighSchoolModel
import com.example.nychighschools.model.data.SchoolRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HighSchoolViewModel : ViewModel(){

    private val repository = SchoolRepository()

    val schoolsInfo = MutableStateFlow<List<HighSchoolModel>>(emptyList())


    fun fetchSchoolsInformation() {
        viewModelScope.launch {

           // try {

                val schools = repository.getSchoolsInfo()
                schoolsInfo.value = schools
           /* } catch (e : Exception){
                //handle exception
                Log.d("Schools Info", " exception${e.toString()}")

            }*/

        }

    }


}