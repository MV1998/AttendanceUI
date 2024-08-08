package com.mohit.jultestforandroid.attendance_feature.di

import com.mohit.jultestforandroid.MainActivity
import dagger.Component

@Component(modules = [DependencyModule::class])
interface ViewModelComponent {
    fun inject(context: MainActivity)
}