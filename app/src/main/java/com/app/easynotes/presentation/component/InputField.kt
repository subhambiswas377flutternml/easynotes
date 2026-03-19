package com.app.easynotes.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aero.notesapp.R
import com.app.easynotes.core.h
import com.app.easynotes.core.w
import com.app.easynotes.ui.theme.CustomFontFamily

@Composable
fun InputField(outerPadding: PaddingValues = PaddingValues(0.dp),
               labelText: String,
               textController: MutableState<String>,
               iconPath: String,
               hintText: String,
               isPassword: Boolean = false){

    val visibilityController = remember { mutableStateOf<Boolean>(value = !isPassword) }

    Column(modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .padding(outerPadding),
        horizontalAlignment = Alignment.Start) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            AssetImageView(imagePath = iconPath,
                modifier = Modifier.height(20.h.dp).width(30.w.dp))
            Spacer(modifier = Modifier.width(8.w.dp))
            Text(
                text = labelText,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = CustomFontFamily.nunitoSansFontFamily,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Spacer(modifier = Modifier.height(12.h.dp))

        OutlinedTextField(value = textController.value,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            suffix = { if(isPassword) Icon(if(visibilityController.value) Icons.Default.VisibilityOff else Icons.Default.Visibility, contentDescription = null, modifier = Modifier.clickable {
                visibilityController.value = !visibilityController.value
            })},
            visualTransformation = if(visibilityController.value) VisualTransformation.None else PasswordVisualTransformation(),
            placeholder = { Text(text = hintText, style = TextStyle(fontFamily = CustomFontFamily.nunitoSansFontFamily,
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )) },
            colors = TextFieldDefaults.colors().copy(
                focusedIndicatorColor = colorResource(R.color.primary_color)
            ),
            onValueChange = {v-> textController.value = v})
    }
}