package com.mohit.jultestforandroid.attendance_feature.database.repository

import com.google.gson.Gson
import com.mohit.jultestforandroid.attendance_feature.database.LocalDB
import com.mohit.jultestforandroid.attendance_feature.models.Attendance

class LocalRepository(localDataSource: LocalDB) : Repository<Attendance> {

    private var attendance: Attendance = Gson().fromJson(localDataSource.jsonData, Attendance::class.java)

    override fun getData(): Attendance {
        return attendance
    }

    override fun putData(): Attendance {
        TODO("Not yet implemented")
    }

    override fun deleteData(): Attendance {
        TODO("Not yet implemented")
    }

    override fun updateData(): Attendance {
        TODO("Not yet implemented")
    }
}