package com.example.realm_demo.data.repository

import com.example.realm_demo.data.Modal.Address
import com.example.realm_demo.data.Modal.Course
import com.example.realm_demo.data.Modal.Student
import com.example.realm_demo.data.Modal.Teacher
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object Mongo {
     lateinit var realm: Realm

     fun configureRealm() {
        val config = RealmConfiguration.Builder(
            schema = setOf(Address::class, Course::class, Student::class, Teacher::class)
        ).build()
        realm = Realm.open(config)
    }
}