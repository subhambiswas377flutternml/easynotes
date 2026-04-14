package com.app.easynotes.core

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.easynotes.LandingScreen
import com.app.easynotes.presentation.auth.provider.AuthViewModel
import com.app.easynotes.presentation.auth.ui.AuthScreen
import com.app.easynotes.presentation.home.HomeScreen
import com.app.easynotes.presentation.walkthrough.WalkThroughA
import com.app.easynotes.presentation.walkthrough.WalkThroughB
import com.app.easynotes.presentation.walkthrough.WalkThroughC
import kotlinx.serialization.Serializable

object Routes {
    @Serializable
    data object LandingRoute

    @Serializable
    data object WalkA

    @Serializable
    data object WalkB

    @Serializable
    data object  WalkC

    @Serializable
    data object Auth

    @Serializable
    data object Home
}

@Composable
fun App(){
    val context: Context = LocalContext.current
    val deviceHeight: Int = LocalConfiguration.current.screenHeightDp
    val deviceWidth: Int = LocalConfiguration.current.screenWidthDp
    val navController = rememberNavController()

    DimensConfiguration.initConfiguration(deviceHeight, deviceWidth)
    SvgLoader.setContext(context)

    // ViewModel
    val authViewModel: AuthViewModel = hiltViewModel<AuthViewModel>()

    NavHost(navController = navController, startDestination = Routes.LandingRoute) {

        composable<Routes.LandingRoute> {
            LandingScreen(navController=navController)
        }

        composable<Routes.WalkA> {
            WalkThroughA(navController)
        }

        composable<Routes.WalkB> {
            WalkThroughB(navController)
        }

        composable<Routes.WalkC> {
            WalkThroughC(navController)
        }

        composable<Routes.Auth> {
            AuthScreen(navController=navController, authViewModel=authViewModel)
        }

        composable<Routes.Home> {
            HomeScreen(navController=navController)
        }
    }
}