package com.mohit.jultestforandroid.attendance_feature.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.mohit.jultestforandroid.R


import com.mohit.jultestforandroid.attendance_feature.models.attendance_reason.AttendanceAbsentReasons

class ReasonSpinnerAdapter(private val context : Context, private val reason : List<AttendanceAbsentReasons>)
    : ArrayAdapter<AttendanceAbsentReasons>(context, 0, reason) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return inflateNewView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return inflateNewView(position, convertView, parent)
    }

    private fun inflateNewView(position: Int, convertView: View?, parent: ViewGroup) : View {
        var updatedConvertView = convertView
        if (convertView == null) {
            updatedConvertView = LayoutInflater.from(context).inflate(R.layout.spinner_single_item, parent, false)
        }

        val reasonText = updatedConvertView?.findViewById<TextView>(R.id.reasonTextId)
        reasonText?.text = reason[position].absentReason

        return updatedConvertView!!
    }
}