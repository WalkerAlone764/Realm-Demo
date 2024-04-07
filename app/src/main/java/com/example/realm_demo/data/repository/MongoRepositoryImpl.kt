package com.example.realm_demo.data.repository

import com.example.realm_demo.data.Modal.Address
import com.example.realm_demo.data.Modal.Course
import com.example.realm_demo.data.Modal.Student
import com.example.realm_demo.data.Modal.Teacher
import com.example.realm_demo.domain.repository.MongoRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class MongoRepositoryImpl : MongoRepository {
    override lateinit var realm: Realm

    override fun configureRealm() {
        val config = RealmConfiguration.Builder(
            schema = setOf(Address::class, Course::class, Student::class, Teacher::class)
        ).build()
        realm = Realm.open(config)
    }
}