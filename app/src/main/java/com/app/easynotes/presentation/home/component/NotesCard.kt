package com.app.easynotes.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aero.notesapp.R
import com.app.easynotes.core.h
import com.app.easynotes.core.w

@Composable
fun Notescard(){
    Box(modifier = Modifier.fillMaxWidth().height(100.h.dp).clip(shape = RoundedCornerShape(10.dp)).background(color = Color.White)
        .padding(horizontal = 15.w.dp, vertical = 15.h.dp)) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.Start) {
            Text("Important",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.text_bold_black),
                )
            )

            Spacer(modifier = Modifier.height(10.h.dp))

            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)

            Spacer(modifier = Modifier.height(10.h.dp))

            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo.",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.text_bold_black),
                )
            )
        }
    }
}