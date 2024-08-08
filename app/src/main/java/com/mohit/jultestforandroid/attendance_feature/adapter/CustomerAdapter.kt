package com.mohit.jultestforandroid.attendance_feature.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mohit.jultestforandroid.R
import com.mohit.jultestforandroid.attendance_feature.models.Group
import com.mohit.jultestforandroid.attendance_feature.models.attendance_reason.ReasonModel
import com.mohit.jultestforandroid.databinding.CustomerItemBinding

class CustomerAdapter (private val context : Context, private val groupList : List<Group>,
                    private val reasonModel: ReasonModel)
    : RecyclerView.Adapter<CustomerAdapter.CustomerAdapterViewHolder>() {

    inner class CustomerAdapterViewHolder(view: CustomerItemBinding) : ViewHolder(view.root) {
        val groupTextId = view.groupTextId
        val groupTextNameId = view.groupTextNameId
        val groupExpansionIconId = view.groupExpansionIconId
        val customerChildRecyclerId = view.customerChildRecyclerId
        val customerChildLinearId =  view.customerChildLinearId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerAdapterViewHolder {
        val binding = CustomerAdapterViewHolder(CustomerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        binding.customerChildRecyclerId.layoutManager = LinearLayoutManager(parent.context)
        binding.customerChildRecyclerId.setHasFixedSize(false)
        return binding
    }

    override fun getItemCount(): Int {
        return groupList.size
    }

    override fun onBindViewHolder(holder: CustomerAdapterViewHolder, position: Int) {
        val group = groupList[position]
        holder.groupTextId.text = group.groupId
        holder.groupTextNameId.text = group.groupName
        holder.customerChildRecyclerId.adapter = CustomerChildAdapter(context, group.customers, reasonModel)

        holder.groupExpansionIconId.setOnClickListener {
            group.isExpanded = !group.isExpanded
            notifyItemChanged(position)
        }

        if (group.isExpanded) {
            holder.groupExpansionIconId.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
            holder.customerChildLinearId.visibility = ViewGroup.VISIBLE
        }else {
            holder.groupExpansionIconId.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
            holder.customerChildLinearId.visibility = ViewGroup.GONE
        }
    }

}