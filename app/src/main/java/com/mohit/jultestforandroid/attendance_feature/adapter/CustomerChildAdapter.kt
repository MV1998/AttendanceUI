package com.mohit.jultestforandroid.attendance_feature.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mohit.jultestforandroid.R
import com.mohit.jultestforandroid.attendance_feature.models.Customer
import com.mohit.jultestforandroid.attendance_feature.models.attendance_reason.ReasonModel
import com.mohit.jultestforandroid.attendance_feature.view_model.AttendanceViewModel
import com.mohit.jultestforandroid.databinding.CustomerChildItemBinding

class CustomerChildAdapter(private val context : Context,
                           private val customers : List<Customer>,
    private val absentList : ReasonModel) :
    RecyclerView.Adapter<CustomerChildAdapter.CustomerChildAdapterViewHolder>() {
    private val spinnerAdapter =  ReasonSpinnerAdapter(context, absentList.AttendanceAbsentReasonsList)
    var attendanceViewModel: AttendanceViewModel? = null

    inner class CustomerChildAdapterViewHolder(view: CustomerChildItemBinding) : ViewHolder(view.root) {
        val customerName = view.customerName
        val customerId = view.customerId
        val presentId = view.presentId
        val absentId = view.absentId
        val reasonSpinnerId = view.reasonSpinnerId
        val reasonSpinnerLinearId = view.reasonSpinnerLinearId


        init {
            presentId.setOnClickListener {
                customers[adapterPosition].isPresent = true
                presentId.setImageResource(R.drawable.green_right_check_24)
                absentId.setImageResource(R.drawable.baseline_radio_button_unchecked_24)
                attendanceViewModel?.validateSubmission()
                notifyItemChanged(adapterPosition)
            }

            absentId.setOnClickListener {
                customers[adapterPosition].isPresent = false
                presentId.setImageResource(R.drawable.baseline_radio_button_unchecked_24)
                absentId.setImageResource(R.drawable.red_wrong_check_24)
                attendanceViewModel?.validateSubmission()
                notifyItemChanged(adapterPosition)
            }

            reasonSpinnerId.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    customers[adapterPosition].reason = absentList.AttendanceAbsentReasonsList[position].absentReason
                    attendanceViewModel?.validateSubmission()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerChildAdapterViewHolder {
        val binding = CustomerChildAdapterViewHolder(CustomerChildItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return binding
    }

    override fun getItemCount(): Int {
        return customers.size
    }

    override fun onBindViewHolder(holder: CustomerChildAdapterViewHolder, position: Int) {
        onBind(holder, position)
    }

    private fun onBind(holder: CustomerChildAdapterViewHolder, position: Int) {
        val customer = customers[position]
        holder.customerName.text = customer.customerName
        holder.customerId.text = customer.customerId

        // code will be changed here

        if (customer.isPresent == null) {
            holder.presentId.setImageResource(R.drawable.baseline_radio_button_unchecked_24)
            holder.absentId.setImageResource(R.drawable.baseline_radio_button_unchecked_24)
            holder.reasonSpinnerLinearId.visibility = View.GONE
        }else {
            if (customer.isPresent!!) {
                holder.presentId.setImageResource(R.drawable.green_right_check_24)
                holder.absentId.setImageResource(R.drawable.baseline_radio_button_unchecked_24)
                holder.reasonSpinnerLinearId.visibility = View.GONE
            }else {
                holder.reasonSpinnerId.adapter = spinnerAdapter
                var selectedIndex = 0
                customer.reason?.let { res ->
                    selectedIndex = absentList.AttendanceAbsentReasonsList.indexOfFirst { it.absentReason == res }
                }
                holder.reasonSpinnerId.setSelection(selectedIndex)
                holder.presentId.setImageResource(R.drawable.baseline_radio_button_unchecked_24)
                holder.absentId.setImageResource(R.drawable.red_wrong_check_24)
                holder.reasonSpinnerLinearId.visibility = View.VISIBLE
            }
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        if (attendanceViewModel == null) {
            attendanceViewModel = ViewModelProvider(recyclerView.context as ViewModelStoreOwner)[AttendanceViewModel::class.java]
        }
    }
}