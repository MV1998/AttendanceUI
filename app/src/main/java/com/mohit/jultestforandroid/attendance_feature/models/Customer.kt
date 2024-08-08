package com.mohit.jultestforandroid.attendance_feature.models

data class Customer(
    val customerId: String,
    val customerName: String,
    val isClick: String,
    var isPresent: Boolean?,
    val lans: List<Any>,
    var reason: String?
)