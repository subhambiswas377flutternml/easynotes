package com.app.easynotes.presentation.walkthrough

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import com.aero.notesapp.R
import com.app.easynotes.core.h
import com.app.easynotes.core.w
import com.app.easynotes.presentation.component.AssetSvgView
import com.app.easynotes.presentation.component.WalkthroughProgress
import com.app.easynotes.ui.theme.CustomFontFamily

@Composable
fun WalkThroughA() {
    Scaffold(modifier = Modifier.padding(horizontal = 24.w.dp)) {innerPadding->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(118.h.dp))

            // Banner image
            AssetSvgView(imageUrl = stringResource(R.string.intro1),
                modifier = Modifier.height(342.h.dp).width(342.w.dp)
            )
            Spacer(modifier = Modifier.height(25.84.h.dp))
            WalkthroughProgress(activeIndex = 0)

            Text(text = stringResource(R.string.walkthrough_title1),
                style = TextStyle(
                    color = colorResource(R.color.text_bold_black),
                    fontWeight = FontWeight.W700,
                    fontSize = 32.81.sp,
                    fontFamily = CustomFontFamily.nunitoSansFontFamily
                )
            )


        }
    }
}