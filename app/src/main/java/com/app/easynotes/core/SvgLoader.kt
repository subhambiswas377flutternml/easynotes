package com.app.easynotes.core

import android.content.Context
import coil.ImageLoader
import coil.decode.SvgDecoder

object SvgLoader {
    lateinit var appContext: Context

    val svgLoader: ImageLoader by lazy {
        ImageLoader.Builder(appContext)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
    }

    fun setContext(context: Context){
        appContext = context
    }
}