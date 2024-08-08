package com.mohit.jultestforandroid

import android.app.Application
import com.mohit.jultestforandroid.attendance_feature.di.DaggerViewModelComponent
import com.mohit.jultestforandroid.attendance_feature.di.DependencyModule
import com.mohit.jultestforandroid.attendance_feature.di.ViewModelComponent

class MyApplication :  Application() {


    override fun onCreate() {
        super.onCreate()


    }
}