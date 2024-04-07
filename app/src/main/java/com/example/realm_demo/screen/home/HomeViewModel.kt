package com.example.realm_demo.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realm_demo.data.Modal.Address
import com.example.realm_demo.data.Modal.Course
import com.example.realm_demo.data.Modal.Student
import com.example.realm_demo.data.Modal.Teacher
import com.example.realm_demo.data.repository.Mongo
import com.example.realm_demo.domain.repository.MongoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.realmSetOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val realm: Realm
): ViewModel() {
        
    val courses = realm.query(Course::class).asFlow().map {
        it.list.toList()
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        emptyList()
    )

    var selectedCourse by mutableStateOf<Course?>(null)
        private set


    fun selectCourse(course: Course) {
        selectedCourse = course
    }

    fun clearSelectedCourse() {
        selectedCourse = null
    }

    init {
//        createSampleData()
    }

    private fun createSampleData() {
        Log.d("helo","dsoa")
        viewModelScope.launch {
           realm.write {
                var address1 = Address().apply {
                    fullName = "Jatin Singhal"
                    city = "Sri Ganganagar"
                    houseNumber = 1016
                    zip  = 335001
                    street = "Aggersain Nagar"
                }
                val teacher = Teacher().apply {
                    address = address1
                }
                val student = Student().apply {
                    name = "Hacker"
                }
               val student2 = Student().apply {
                   name = "Albert"
               }


                val course = Course().apply {
                    name = "Jetpack Compose Basic"
                    enrolledStudents = realmSetOf(student, student2)
                }
                teacher.courses = realmSetOf(course)
                address1.teacher = teacher

                copyToRealm(teacher, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(student, updatePolicy = UpdatePolicy.ALL)
               copyToRealm(student2, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(course, updatePolicy = UpdatePolicy.ALL)

            }
        }
    }

    fun deleteCourse(course: Course) {
        viewModelScope.launch(Dispatchers.IO) {
            realm.write {
                val latestCourse = findLatest(course)
                if(latestCourse !=  null) {
                    delete(latestCourse)
                    selectedCourse = null
                }
            }
        }
    }

}