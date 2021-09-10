package com.example.loluserinfoapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LoLChampApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}