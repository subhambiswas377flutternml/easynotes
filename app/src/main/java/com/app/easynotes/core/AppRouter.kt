package com.app.easynotes.core

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.easynotes.LandingScreen
import com.app.easynotes.presentation.walkthrough.WalkThroughA
import kotlinx.serialization.Serializable

object Routes {
    @Serializable
    data object LandingRoute

    @Serializable
    data object WalkA
}

@Composable
fun App(){
    val context: Context = LocalContext.current
    val deviceHeight: Int = LocalConfiguration.current.screenHeightDp
    val deviceWidth: Int = LocalConfiguration.current.screenWidthDp
    val navController = rememberNavController()

    DimensConfiguration.initConfiguration(deviceHeight, deviceWidth)
    SvgLoader.setContext(context)

    NavHost(navController = navController, startDestination = Routes.LandingRoute) {

        composable<Routes.LandingRoute> {
            LandingScreen(navController=navController)
        }

        composable<Routes.WalkA> {
            WalkThroughA()
        }
    }
}