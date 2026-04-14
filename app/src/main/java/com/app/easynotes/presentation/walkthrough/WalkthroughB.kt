package com.app.easynotes.presentation.walkthrough

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aero.notesapp.R
import com.app.easynotes.core.Routes
import com.app.easynotes.core.h
import com.app.easynotes.core.w
import com.app.easynotes.presentation.component.AssetSvgView
import com.app.easynotes.presentation.component.PrimaryButton
import com.app.easynotes.presentation.component.WalkthroughProgress
import com.app.easynotes.ui.theme.CustomFontFamily

@Composable
fun WalkThroughB(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Scaffold(modifier = Modifier.padding(horizontal = 24.w.dp)) {innerPadding->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding).verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(110.h.dp))

            // Banner image
            AssetSvgView(imageUrl = stringResource(R.string.intro2),
                modifier = Modifier.height(342.h.dp).width(342.w.dp)
            )
            Spacer(modifier = Modifier.height(24.8.h.dp))
            WalkthroughProgress(activeIndex = 1)

            Spacer(modifier = Modifier.height(30.h.dp))
            Text(text = stringResource(R.string.walkthrough_title2),
                style = TextStyle(
                    color = colorResource(R.color.text_bold_black),
                    fontWeight = FontWeight.W700,
                    textAlign = TextAlign.Center,
                    fontSize = 32.81.sp,
                    fontFamily = CustomFontFamily.nunitoSansFontFamily
                )
            )

            Spacer(modifier = Modifier.height(6.h.dp))
            Text(text = stringResource(R.string.walkthrough_subtitle2),
                style = TextStyle(
                    color = colorResource(R.color.text_bold_black),
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 14.96.sp,
                    fontFamily = CustomFontFamily.nunitoSansFontFamily
                )
            )

            Spacer(modifier = Modifier.height(15.h.dp))
            PrimaryButton(buttonText = "Next", onClick = {navController.navigate(Routes.WalkC)})
            Spacer(modifier = Modifier.height(20.h.dp))
        }
    }
}