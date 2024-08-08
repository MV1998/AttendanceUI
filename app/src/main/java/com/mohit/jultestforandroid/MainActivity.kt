package com.mohit.jultestforandroid

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.mohit.jultestforandroid.attendance_feature.adapter.CustomerAdapter
import com.mohit.jultestforandroid.attendance_feature.database.LocalDB
import com.mohit.jultestforandroid.attendance_feature.database.repository.LocalReasonRepository
import com.mohit.jultestforandroid.attendance_feature.database.repository.LocalRepository
import com.mohit.jultestforandroid.attendance_feature.di.DaggerViewModelComponent
import com.mohit.jultestforandroid.attendance_feature.di.DependencyModule
import com.mohit.jultestforandroid.attendance_feature.models.Attendance
import com.mohit.jultestforandroid.attendance_feature.models.attendance_reason.ReasonModel
import com.mohit.jultestforandroid.attendance_feature.view_model.AttendanceViewModel
import com.mohit.jultestforandroid.attendance_feature.view_model.GroupViewModelFactory
import com.mohit.jultestforandroid.attendance_feature.view_model.UiState
import com.mohit.jultestforandroid.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var attendanceViewModel: AttendanceViewModel

    private lateinit var customerAdapter : CustomerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initDagger()

        attendanceViewModel.uiState.observe(this) {
            setupRecyclerView(it as UiState.DataState)
            attendanceViewModel.validateSubmission()
        }

        attendanceViewModel.validate.observe(this) {
            binding.submitButtonId.isEnabled = it
        }

        binding.submitButtonId.setOnClickListener {
            Log.d("TAG", "onCreate: ${Gson().toJson((attendanceViewModel.uiState.value as UiState.DataState).attendance)}}")
        }
    }

    private fun initDagger() {
        val dependencyModule = DependencyModule(this)
        val component = DaggerViewModelComponent.builder()
            .dependencyModule(dependencyModule)
            .build()
        // viewmodel store owner
        component.inject(this@MainActivity)
    }

    // later will be done by LiveData and ViewModel
    private fun setupRecyclerView(dataState: UiState.DataState) {
        val recyclerView = binding.customerRecyclerViewId
        customerAdapter = CustomerAdapter(this@MainActivity, dataState.attendance.groups, dataState.reasonModel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(false)
        recyclerView.adapter = customerAdapter
    }

}