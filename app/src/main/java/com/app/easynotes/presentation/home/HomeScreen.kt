package com.app.easynotes.presentation.home

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.aero.notesapp.R
import com.app.easynotes.core.AppConstants
import com.app.easynotes.core.h
import com.app.easynotes.core.w
import com.app.easynotes.presentation.component.AssetSvgView
import com.app.easynotes.presentation.component.CategoryCard
import com.app.easynotes.presentation.component.InputField

@Composable
fun HomeScreen(navController: NavHostController){

    val verticalScrollController = rememberScrollState()
    val searchController: MutableState<String> = remember { mutableStateOf<String>("") }

    Scaffold(modifier = Modifier.padding(all = 0.dp),
        containerColor = colorResource(R.color.primary_bg_color)
    ) { innerPadding->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = AppConstants.horizontalPaddingValue.w.dp)
            .verticalScroll(verticalScrollController)) {

            // heading and more
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Notes",
                    style = TextStyle(
                        color = colorResource(R.color.text_bold_black),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                AssetSvgView(imageUrl = stringResource(R.string.more_horiz), modifier = Modifier.height(22.h.dp).width(22.w.dp))
            }

            Spacer(modifier = Modifier.height(20.h.dp))

            InputField(textController = searchController,
                hintText = "Search",
                unfocusColor = Color.Transparent,
                hintFontSize = 18
            )

            Spacer(modifier = Modifier.height(20.5.h.dp))

            Row(modifier = Modifier.fillMaxWidth()){
                CategoryCard(modifier = Modifier.weight(1f), title="All Notes" ,imageUrl = stringResource(R.string.all_notes))
                Spacer(modifier = Modifier.width(10.w.dp))
                CategoryCard(modifier = Modifier.weight(1f), title="Favourites", imageUrl = stringResource(R.string.fav))

            }

            Spacer(modifier = Modifier.height(10.h.dp))

            Row(modifier = Modifier.fillMaxWidth()){
                CategoryCard(modifier = Modifier.weight(1f), title="Hidden", imageUrl = stringResource(R.string.hidden))
                Spacer(modifier = Modifier.width(10.w.dp))
                CategoryCard(modifier = Modifier.weight(1f), title="Trash", imageUrl = stringResource(R.string.trash))

            }
        }
    }
}