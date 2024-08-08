package com.mohit.jultestforandroid.attendance_feature.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohit.jultestforandroid.attendance_feature.database.repository.Repository
import com.mohit.jultestforandroid.attendance_feature.models.Attendance
import com.mohit.jultestforandroid.attendance_feature.models.attendance_reason.ReasonModel
import javax.inject.Inject

sealed class UiState {
    data class DataState(
        var attendance: Attendance,
        val reasonModel: ReasonModel) : UiState()
}


class AttendanceViewModel @Inject constructor(private val attendanceRepository : Repository<Attendance>,
                          private val reasonRepository : Repository<ReasonModel>) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> get() =  _uiState

    private val _validate = MutableLiveData<Boolean>(false)
    val validate : LiveData<Boolean> get() = _validate

    init {
        fetchData()
    }

    private fun fetchData() {
        val attendance = attendanceRepository.getData()
        val reasonModel = reasonRepository.getData()
        _uiState.value = UiState.DataState(attendance, reasonModel)
    }

    fun validateSubmission() {
        // Note : Try to solve this problem with optimum way.

        //if n will be less than 10K this is optimal approach.
        // Brute force approach - Time complexity around O(N^2)

       (uiState.value as UiState.DataState).attendance.groups.flatMap { it.customers.toList() }.forEach { customer ->
            if (customer.isPresent == null) {
                _validate.value = false
                return
            }
            if (customer.reason == null || customer.reason == "Select Reason") {
                if (!customer.isPresent!!) {
                    _validate.value = false
                    return
                }
            }
            _validate.value = true
        }
    }
}