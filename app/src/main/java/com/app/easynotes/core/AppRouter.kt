package com.app.easynotes.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.easynotes.LandingScreen
import kotlinx.serialization.Serializable

object Routes {
    @Serializable
    data object LandingRoute
}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.LandingRoute) {

        composable<Routes.LandingRoute> {
            LandingScreen()
        }

    }
}