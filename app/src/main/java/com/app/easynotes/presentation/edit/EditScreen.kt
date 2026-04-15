package com.app.easynotes.presentation.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.easynotes.core.AppConstants
import com.app.easynotes.core.w

@Composable
fun EditScreen(navController: NavHostController){
    Scaffold(modifier = Modifier.padding(horizontal = AppConstants.horizontalPaddingValue.w.dp)) { innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {

        }
    }
}