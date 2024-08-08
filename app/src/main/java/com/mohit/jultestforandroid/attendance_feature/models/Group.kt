package com.mohit.jultestforandroid.attendance_feature.models

data class Group(
    val customers: List<Customer>,
    val groupDue: Int,
    val groupId: String,
    val groupName: String,
    val noOfCustomers: Int,
    var isExpanded : Boolean = false,
    val noOfLans: Int
)