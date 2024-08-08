package com.mohit.jultestforandroid.attendance_feature.di

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mohit.jultestforandroid.attendance_feature.database.LocalDB
import com.mohit.jultestforandroid.attendance_feature.database.repository.LocalReasonRepository
import com.mohit.jultestforandroid.attendance_feature.database.repository.LocalRepository
import com.mohit.jultestforandroid.attendance_feature.database.repository.Repository
import com.mohit.jultestforandroid.attendance_feature.models.Attendance
import com.mohit.jultestforandroid.attendance_feature.models.attendance_reason.ReasonModel
import com.mohit.jultestforandroid.attendance_feature.view_model.AttendanceViewModel
import com.mohit.jultestforandroid.attendance_feature.view_model.GroupViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

// interface, class, abstract class
@Module
class DependencyModule(private val context: Context) {

    @Provides
    fun getAttendanceRepository(localDataSource: LocalDB): Repository<Attendance> {
        return LocalRepository(localDataSource)
    }

    @Provides
    fun getReasonRepository(localDataSource: LocalDB): Repository<ReasonModel> {
        return LocalReasonRepository(localDataSource)
    }

    @Provides
    fun getContext(): Context {
        return context
    }

    @Provides
    fun getGroupViewModel(
        context: Context,
        attendanceRepository: Repository<Attendance>,
        reasonRepository: Repository<ReasonModel>
    ): AttendanceViewModel {
        val groupViewModelFactory = GroupViewModelFactory(attendanceRepository, reasonRepository)
        return ViewModelProvider(
            context as ViewModelStoreOwner,
            groupViewModelFactory
        )[AttendanceViewModel::class.java]
    }



    @Provides
    fun getLocalDB(): LocalDB {
        return LocalDB
    }
}