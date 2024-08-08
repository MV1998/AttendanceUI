package com.mohit.jultestforandroid.attendance_feature.models.attendance_reason

data class ReasonModel(
    val AttendanceAbsentReasonsList: List<AttendanceAbsentReasons>,
    val errorCode: Int,
    val errorMessage: String
)