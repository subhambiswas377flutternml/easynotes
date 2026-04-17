package com.app.easynotes.presentation.edit

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
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

    val titleController: MutableState<String> = remember { mutableStateOf<String>(value = "") }
    val contentController: MutableState<String> = remember { mutableStateOf<String>(value = "") }

    Scaffold(modifier = Modifier.padding(start = AppConstants.horizontalPaddingValue.w.dp,
        end = AppConstants.horizontalPaddingValue.w.dp,
        top = 70.h.dp),
        topBar = {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {

                AssetSvgView(imageUrl = stringResource(R.string.arrow_back),
                    modifier = Modifier.height(20.h.dp).width(12.w.dp).clickable {
                        navController.navigateUp()
                    })

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

            Spacer(modifier = Modifier.height(30.h.dp))

            // Heading
            BasicTextField(
                value = titleController.value,
                onValueChange = {it-> titleController.value = it},
                modifier = Modifier.fillMaxWidth(),
                maxLines = 3,
                cursorBrush = SolidColor(Color.Black),
                textStyle = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Black,
                ),
                decorationBox = { innerTextField ->
                    if (titleController.value.isEmpty()) {
                        Text(
                            text = "Page Title",
                            style = TextStyle(
                                fontSize = 26.sp,
                                fontWeight = FontWeight.W500,
                                color = Color.Gray,
                            ),
                        )
                    }

                    Box(modifier = Modifier.fillMaxWidth().background(Color.Transparent)) {
                        innerTextField()
                    }
                }
            )

            Spacer(modifier = Modifier.height(15.h.dp))

            // Notes
            BasicTextField(
                value = contentController.value,
                onValueChange = {it-> contentController.value = it},
                modifier = Modifier.fillMaxWidth(),
                cursorBrush = SolidColor(Color.Black),
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black,
                ),
                decorationBox = { innerTextField ->
                    if (contentController.value.isEmpty()) {
                        Text(
                            text = "Note",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.W400,
                                color = Color.Gray,
                            ),
                        )
                    }
                    Box(modifier = Modifier.fillMaxWidth().background(Color.Transparent)) {
                        innerTextField()
                    }
                }
            )
        }
    }
}