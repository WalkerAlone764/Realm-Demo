package com.example.realm_demo.screen.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realm_demo.data.Modal.Course
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@Composable
fun CourseItem(
    modifier: Modifier = Modifier,
    course: Course,
    onClickCourse: (Course) -> Unit
) {




    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
            .clickable {
                onClickCourse(course)
            }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = course.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "course by ${course.teacher.toList().first()._id}",
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(18.dp))
//            course.enrolledStudents.toList().forEach {
//                Text(text = "Student who enrolled: ${it.name}")
//            }
            val stu = course.enrolledStudents.toList().map {
                it.name
            }

            Text(text ="Student who enrolled: ${stu.joinToString(",")}" )
        }
    }
}