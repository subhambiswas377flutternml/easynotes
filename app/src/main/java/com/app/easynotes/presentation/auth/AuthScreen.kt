package com.app.easynotes.presentation.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.app.easynotes.core.AppConstants
import com.app.easynotes.core.Routes
import com.app.easynotes.core.h
import com.app.easynotes.core.w
import com.app.easynotes.presentation.component.AssetImageView
import com.app.easynotes.presentation.component.InputField
import com.app.easynotes.presentation.component.PrimaryButton

enum class AuthType{
    SIGNUP,
    LOGIN,
}

@Composable
fun AuthScreen(navController: NavHostController){

    val emailController = remember { mutableStateOf<String>("") }
    val passwordController = remember { mutableStateOf<String>("") }

    val currentAuthType = remember { mutableStateOf<AuthType>(value = AuthType.LOGIN) }

    Scaffold(modifier = Modifier.padding(all = 0.dp)) { innerPadding->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally) {

            AssetImageView(imagePath = stringResource(R.string.auth_banner),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.h.dp))

            Spacer(modifier = Modifier.height(20.h.dp))
            Text(text = if(currentAuthType.value==AuthType.LOGIN) "Welcome Back!" else "New Here!",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.text_bold_black),
                    fontSize = 32.sp
                )
            )

            Spacer(modifier = Modifier.height(8.h.dp))
            Text(text = if(currentAuthType.value==AuthType.LOGIN) "Login to continue." else "Sign up to continue.",
                style = TextStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                )
            )

            Spacer(modifier=Modifier.height(20.h.dp))

            InputField(outerPadding = PaddingValues(horizontal = 22.w.dp),
                labelText = "Email",
                iconPath = stringResource(R.string.mail_icon),
                hintText = "Enter your email",
                textController = emailController,
            )

            Spacer(modifier=Modifier.height(30.h.dp))

            InputField(outerPadding = PaddingValues(horizontal = 22.w.dp),
                labelText = "Password",
                iconPath = stringResource(R.string.password_icon),
                hintText = "Enter your password",
                textController = passwordController,
                isPassword = true
            )

            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.padding(horizontal = AppConstants.horizontalPaddingValue.w.dp)) {
                PrimaryButton(buttonText = if(currentAuthType.value==AuthType.LOGIN) "Login" else "Sign Up", onClick = {
                    navController.navigate(Routes.Home)
                })
            }
            Spacer(modifier = Modifier.height(10.h.dp))
            Row {
                Text(
                    text = if(currentAuthType.value==AuthType.LOGIN) "Don't have an account? " else "Already have an account? ",
                    style = TextStyle(
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                    )
                )

                Text(
                    text = if(currentAuthType.value==AuthType.LOGIN) "Sign Up" else "Login",
                    modifier = Modifier.clickable {
                        if(currentAuthType.value==AuthType.LOGIN){
                            currentAuthType.value = AuthType.SIGNUP
                        }else{
                            currentAuthType.value = AuthType.LOGIN
                        }
                    },
                    style = TextStyle(
                        color = colorResource(R.color.primary_color),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                    )
                )
            }
            Spacer(modifier = Modifier.height(35.h.dp))
        }
    }
}