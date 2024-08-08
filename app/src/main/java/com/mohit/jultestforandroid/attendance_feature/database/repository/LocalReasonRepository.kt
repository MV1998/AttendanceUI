package com.mohit.jultestforandroid.attendance_feature.database.repository

import com.google.gson.Gson
import com.mohit.jultestforandroid.attendance_feature.database.LocalDB
import com.mohit.jultestforandroid.attendance_feature.models.attendance_reason.ReasonModel

class LocalReasonRepository(localDataSource: LocalDB): Repository<ReasonModel> {


    // We can think of this data is being fetch from local Room DB.
    private val reason = Gson().fromJson(localDataSource.reason, ReasonModel::class.java)

    override fun getData(): ReasonModel {
        return reason
    }

    override fun putData(): ReasonModel {
        TODO("Not yet implemented")
    }

    override fun deleteData(): ReasonModel {
        TODO("Not yet implemented")
    }

    override fun updateData(): ReasonModel {
        TODO("Not yet implemented")
    }
}