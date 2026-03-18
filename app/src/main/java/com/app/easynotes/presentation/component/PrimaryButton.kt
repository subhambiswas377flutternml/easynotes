package com.app.easynotes.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aero.notesapp.R
import com.app.easynotes.core.h

@Composable
fun PrimaryButton(buttonText: String, onClick:()-> Unit= {}){
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth().height(56.h.dp),
            shape = RoundedCornerShape(14.dp),
            contentPadding = PaddingValues(vertical = 10.h.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = colorResource(R.color.primary_color),
                contentColor = Color.White
            )
        ) {
            Text(
                text = buttonText,
                style = TextStyle(
                    fontWeight = FontWeight.W700,
                    fontSize = 17.sp,
                )
            )
        }
}