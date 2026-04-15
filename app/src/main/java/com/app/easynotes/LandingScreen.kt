package com.app.easynotes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aero.notesapp.R
import com.app.easynotes.core.Routes
import com.app.easynotes.presentation.auth.provider.AuthViewModel
import com.app.easynotes.presentation.auth.provider.UIEvents
import com.app.easynotes.presentation.component.AssetImageView
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import okhttp3.Route

@Composable
fun LandingScreen(navController: NavHostController, authViewModel: AuthViewModel){

    LaunchedEffect(Unit) {
        delay(1500L)

        authViewModel.fetchAuth()

        authViewModel.uiEventsAction.collect{action->
            when(action){
                UIEvents.SuccessAndNavigate -> {
                    navController.navigate(Routes.Home){
                        popUpTo<Routes.LandingRoute>(){
                            inclusive=true
                        }
                    }
                }

                UIEvents.FailureAndStay -> {
                    navController.navigate(Routes.WalkA){
                        popUpTo<Routes.LandingRoute>(){
                            inclusive = true
                        }
                    }
                }
            }
        }
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        AssetImageView(imagePath = stringResource(R.string.app_icon),
            modifier = Modifier.height(200.dp).width(200.dp))
    }
}