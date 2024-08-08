package com.mohit.jultestforandroid.attendance_feature.models

data class Attendance(
    val centerId: String,
    val centerName: String,
    val errorCode: Any,
    val errorMessage: Any,
    val groups: List<Group>,
    val lans: List<Any>,
    val nextMeetingDate: String
)