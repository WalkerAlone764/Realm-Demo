package com.example.realm_demo.data.Modal

import io.realm.kotlin.ext.backlinks
import io.realm.kotlin.ext.realmSetOf
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmSet
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Teacher: RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var address: Address? = null
    var courses: RealmSet<Course> = realmSetOf()
}
