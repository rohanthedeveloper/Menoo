package com.example.menoo

import android.app.Application
import com.google.firebase.FirebaseApp

//import dagger.hilt.android.HiltAndroidApp
//
//@HiltAndroidApp
class MenooApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}