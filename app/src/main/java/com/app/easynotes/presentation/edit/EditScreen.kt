package com.app.easynotes.presentation.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aero.notesapp.R
import com.app.easynotes.core.AppConstants
import com.app.easynotes.core.h
import com.app.easynotes.core.w
import com.app.easynotes.presentation.component.AssetSvgView
import com.app.easynotes.presentation.component.PrimaryButton
import com.app.easynotes.ui.theme.CustomFontFamily

@Composable
fun EditScreen(navController: NavHostController){
    Scaffold(modifier = Modifier.padding(start = AppConstants.horizontalPaddingValue.w.dp,
        end = AppConstants.horizontalPaddingValue.w.dp,
        top = 70.h.dp),
        topBar = {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                AssetSvgView(imageUrl = stringResource(R.string.arrow_back),
                    modifier = Modifier.height(20.h.dp).width(12.w.dp))
                Spacer(modifier = Modifier.width(10.w.dp))
                Text("Back",
                    style = TextStyle(
                        fontFamily = CustomFontFamily.nunitoSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.58.sp,
                        color = colorResource(R.color.primary_color)
                    ))

                Spacer(modifier = Modifier.weight(1f))

                PrimaryButton(buttonText = "Save",
                    onClick = {},
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    bgColor = Color.Black,
                    modifier = Modifier.height(35.h.dp).width(70.w.dp),
                    cornerRadius = 10,
                )
            }
        }) { innerPadding->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
        }
    }
}