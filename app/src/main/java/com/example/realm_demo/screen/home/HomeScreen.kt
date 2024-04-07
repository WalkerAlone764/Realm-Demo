package com.example.realm_demo.screen.home

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.realm_demo.data.Modal.Course
import com.example.realm_demo.screen.home.components.CourseItem

@Composable
fun HomeScreen(
    courses: List<Course>,
    selectedCourse: Course? = null,
    onClickCourse: (Course) -> Unit,
    onClearCourse: () -> Unit,
    onDeleteCourse: (Course) -> Unit
) {

    Scaffold {
        Column(
            modifier = Modifier.padding(it)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(courses) {course ->
                    CourseItem(course = course, onClickCourse =onClickCourse )
                }
            }

            if(selectedCourse != null) {
                Dialog(onDismissRequest = onClearCourse) {
                    Surface(
                        modifier = Modifier
                            .widthIn(280.dp, 320.dp)
                            .clip(RoundedCornerShape(22.dp))
                            .background(Color.White)
                            .padding(16.dp)

                    ) {
                        Column {
                            Text(text = selectedCourse.teacher.toList().first().address!!.fullName)
                            Text(text = "${selectedCourse.teacher.toList().first().address!!.houseNumber} ${selectedCourse.teacher.toList().first().address!!.street}")
                            Text(text = "${selectedCourse.teacher.toList().first().address!!.zip} ${selectedCourse.teacher.toList().first().address!!.city}")
                            Spacer(modifier = Modifier.height(12.dp))
                            Button(
                                onClick = {
                                          onDeleteCourse(selectedCourse)
                                },
                                colors =  ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.errorContainer,
                                    contentColor = MaterialTheme.colorScheme.onErrorContainer
                                )
                            ) {
                                Text(text = "Delete")
                            }

                        }

                    }
                }
            }
        }
    }

}