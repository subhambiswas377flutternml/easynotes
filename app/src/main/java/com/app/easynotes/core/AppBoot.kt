package com.app.easynotes.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppBoot() : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}