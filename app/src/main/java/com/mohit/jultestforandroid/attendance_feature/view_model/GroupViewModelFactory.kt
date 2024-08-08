package com.mohit.jultestforandroid.attendance_feature.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mohit.jultestforandroid.attendance_feature.database.repository.Repository
import com.mohit.jultestforandroid.attendance_feature.models.Attendance
import com.mohit.jultestforandroid.attendance_feature.models.attendance_reason.ReasonModel

class GroupViewModelFactory(private val attendanceRepository: Repository<Attendance>,
    private val reasonRepository : Repository<ReasonModel>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AttendanceViewModel(attendanceRepository, reasonRepository) as T
    }
}