package com.app.easynotes.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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

@Composable
fun CategoryCard(modifier: Modifier,
                 imageUrl: String,
                 title: String,
                 onSelected:()->Unit = {}){
    Card(modifier = modifier,
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White
        )) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 15.w.dp, vertical = 9.h.dp)) {
            AssetSvgView(imageUrl = imageUrl, modifier = Modifier.height(32.h.dp).width(32.w.dp))
            Spacer(modifier = Modifier.width(10.w.dp))
            Text(
                text = title,
                style = TextStyle(
                    color = colorResource(R.color.text_bold_black),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            )
        }
    }
}