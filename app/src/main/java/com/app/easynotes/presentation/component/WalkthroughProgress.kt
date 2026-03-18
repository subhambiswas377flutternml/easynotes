package com.app.easynotes.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.aero.notesapp.R
import com.app.easynotes.core.h

@Composable
fun WalkthroughProgress(activeIndex: Int){
    Row(modifier = Modifier.fillMaxWidth()) {
        for(i:Int in 0 until 3)
            if(i==activeIndex)
                Box(modifier = Modifier.weight(1f).height(4.63.h.dp).fillMaxWidth().background(color = colorResource(
                    R.color.progress_blue)
                ))
            else
                Box(modifier = Modifier.weight(1f).height(4.63.h.dp).fillMaxWidth().background(color = colorResource(
                    R.color.progress_grey)
                ))
    }
}