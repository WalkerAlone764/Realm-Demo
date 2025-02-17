package com.example.realm_demo.data.Modal

import io.realm.kotlin.types.EmbeddedRealmObject

class Address: EmbeddedRealmObject {
    var fullName: String = ""
    var street: String = ""
    var houseNumber: Int = 0
    var zip: Int = 0
    var city: String = ""
    var teacher: Teacher? = null
}