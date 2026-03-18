package com.app.easynotes.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aero.notesapp.R
import com.app.easynotes.core.h
import com.app.easynotes.presentation.component.AssetImageView
import com.app.easynotes.ui.theme.CustomFontFamily

@Composable
fun AuthScreen(navController: NavHostController){
    Scaffold(modifier = Modifier.padding(all = 0.dp)) { innerPadding->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally) {

            AssetImageView(imagePath = stringResource(R.string.auth_banner),
                modifier = Modifier.fillMaxWidth().height(300.h.dp))

            Spacer(modifier = Modifier.height(20.h.dp))
            Text(text = "Welcome Back!",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.text_bold_black),
                    fontSize = 32.sp
                )
            )

            Spacer(modifier = Modifier.height(8.h.dp))
            Text(text = "Login to continue.",
                style = TextStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                )
            )
        }
    }
}