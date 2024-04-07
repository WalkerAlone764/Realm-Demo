package com.example.realm_demo.domain.repository

import io.realm.kotlin.Realm

interface MongoRepository {

    var realm: Realm

    fun configureRealm()

}