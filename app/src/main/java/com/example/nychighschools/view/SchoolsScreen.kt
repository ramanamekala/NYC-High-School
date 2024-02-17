package com.example.nychighschools.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nychighschools.model.data.HighSchoolModel
import com.example.nychighschools.viewmodel.HighSchoolViewModel


@Composable
fun DisplaySchoolsInfoScreen(viewModel: HighSchoolViewModel){

    val schoolsList = viewModel.schoolsInfo.collectAsState().value

    LaunchedEffect(Unit) {

        viewModel.fetchSchoolsInformation()
    }

   Column {
       
       if(schoolsList.isEmpty()){
           
          Text(text = "Loading ....") 
           
       } else {
               LazyColumn {


                   items(schoolsList) { schoolInfo ->

                       SchoolInfo(schoolInfo = schoolInfo, onItemClick = { selectedSchoolInfo ->

                           // Handle item click, e.g., navigate to detail screen
                       })

                   }

               }
           
       }
       
   }


}


@Composable
fun SchoolInfo(schoolInfo: HighSchoolModel, onItemClick: (HighSchoolModel) -> Unit) {
    // Your item UI code here
    // Detect click and invoke the onItemClick lambda
    Box(
        modifier = Modifier
            .clickable { onItemClick(schoolInfo) }
            .padding(16.dp)
    ) {
        Text(text = schoolInfo.schoolName?:"", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = schoolInfo.dbn?:"", fontSize = 14.sp, color = Color.Gray)

        Divider()
    }
}

