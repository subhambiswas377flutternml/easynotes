package com.app.easynotes.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aero.notesapp.R
import com.app.easynotes.core.AppConstants
import com.app.easynotes.core.h
import com.app.easynotes.core.w

@Composable
fun RecentNotes(){
    Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
        Text(text = "Recent Notes",
            modifier = Modifier.padding(horizontal = AppConstants.horizontalPaddingValue.w.dp),
            style = TextStyle(
                color = colorResource(R.color.text_bold_black),
                fontWeight = FontWeight.W700,
                fontSize = 15.63.sp,
            )
        )

        Spacer(modifier = Modifier.height(15.h.dp))

       LazyRow(modifier = Modifier.height(198.h.dp),
           horizontalArrangement = Arrangement.spacedBy(16.w.dp),
           contentPadding = PaddingValues(horizontal = AppConstants.horizontalPaddingValue.w.dp)
       ) { items(4){
           RecentCard()
       } }
    }
}
