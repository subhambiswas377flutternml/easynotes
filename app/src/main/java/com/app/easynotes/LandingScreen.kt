package com.app.easynotes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.aero.notesapp.R
import com.app.easynotes.core.Routes
import com.app.easynotes.presentation.component.AssetImageView
import kotlinx.coroutines.delay

@Composable
fun LandingScreen(navController: NavHostController){

    LaunchedEffect(Unit) {
        delay(1500L)
        navController.navigate(Routes.WalkA){
            popUpTo<Routes.LandingRoute>(){
                inclusive=true
            }
        }
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        AssetImageView(imagePath = stringResource(R.string.app_icon))
    }
}