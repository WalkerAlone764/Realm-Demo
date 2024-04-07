package com.example.realm_demo.data.Modal

import io.realm.kotlin.ext.backlinks
import io.realm.kotlin.ext.realmSetOf
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmSet
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

class Course: RealmObject {
    @PrimaryKey
    var _id: ObjectId = BsonObjectId()
    var name: String = ""
    val teacher: RealmResults<Teacher> by backlinks(Teacher::courses)
    var enrolledStudents: RealmSet<Student> = realmSetOf()
}
