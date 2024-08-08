package com.mohit.jultestforandroid.attendance_feature.database.repository

interface Repository<T> {
    fun getData(): T
    fun putData() : T
    fun deleteData() : T
    fun updateData() : T
}