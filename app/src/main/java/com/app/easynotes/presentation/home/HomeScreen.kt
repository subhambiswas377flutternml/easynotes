package com.app.easynotes.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import com.app.easynotes.core.Routes
import com.app.easynotes.core.h
import com.app.easynotes.core.w
import com.app.easynotes.presentation.component.AssetSvgView
import com.app.easynotes.presentation.component.CategoryCard
import com.app.easynotes.presentation.component.InputField
import com.app.easynotes.presentation.home.component.Notescard
import com.app.easynotes.presentation.home.component.RecentNotes

@Composable
fun HomeScreen(navController: NavHostController){

    val verticalScrollController = rememberScrollState()
    val searchController: MutableState<String> = remember { mutableStateOf<String>("") }

    Scaffold(modifier = Modifier.padding(all = 0.dp),
        containerColor = colorResource(R.color.primary_bg_color),
        topBar = {
            // heading and more
            Row(modifier = Modifier.fillMaxWidth().wrapContentHeight().
            padding(start = AppConstants.horizontalPaddingValue.w.dp, end = AppConstants.horizontalPaddingValue.w.dp, top = 45.h.dp, bottom = 20.h.dp),
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
            }},
        floatingActionButton = { FloatingActionButton(onClick = {
            navController.navigate(Routes.Edit)
        }){
            Icon(Icons.Default.Add, contentDescription = "")
        } }
    ) { innerPadding->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(verticalScrollController)) {

            InputField(textController = searchController,
                hintText = "Search",
                unfocusColor = Color.Transparent,
                hintFontSize = 18,
                modifier = Modifier.padding(horizontal = AppConstants.horizontalPaddingValue.w.dp)
            )

            Spacer(modifier = Modifier.height(20.5.h.dp))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = AppConstants.horizontalPaddingValue.w.dp)){
                CategoryCard(modifier = Modifier.weight(1f), title="All Notes" ,imageUrl = stringResource(R.string.all_notes))
                Spacer(modifier = Modifier.width(10.w.dp))
                CategoryCard(modifier = Modifier.weight(1f), title="Favourites", imageUrl = stringResource(R.string.fav))

            }

            Spacer(modifier = Modifier.height(10.h.dp))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = AppConstants.horizontalPaddingValue.w.dp)){
                CategoryCard(modifier = Modifier.weight(1f), title="Hidden", imageUrl = stringResource(R.string.hidden))
                Spacer(modifier = Modifier.width(10.w.dp))
                CategoryCard(modifier = Modifier.weight(1f), title="Trash", imageUrl = stringResource(R.string.trash))

            }

            Spacer(modifier = Modifier.height(20.h.dp))

            // Recent Notes
            RecentNotes()

            Spacer(modifier = Modifier.height(15.h.dp))

            Text(text = "Notes",
                modifier = Modifier.padding(horizontal = AppConstants.horizontalPaddingValue.w.dp),
                style = TextStyle(
                    color = colorResource(R.color.text_bold_black),
                    fontWeight = FontWeight.W700,
                    fontSize = 15.63.sp,
                )
            )

            Spacer(modifier = Modifier.height(15.h.dp))

            // Notes
            Column(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = AppConstants.horizontalPaddingValue.w.dp),
                verticalArrangement = Arrangement.spacedBy(8.h.dp)
            ) {
                repeat(3){
                    Notescard()
                }
            }


            Spacer(modifier = Modifier.height(20.h.dp))
        }
    }
}