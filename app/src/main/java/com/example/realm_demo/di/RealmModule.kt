package com.example.realm_demo.di

import android.content.Context
import com.example.realm_demo.data.Modal.Address
import com.example.realm_demo.data.Modal.Course
import com.example.realm_demo.data.Modal.Student
import com.example.realm_demo.data.Modal.Teacher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RealmModule {

    @Provides
    @Singleton
    fun provideRealm(@ApplicationContext context: Context): Realm {
        val config = RealmConfiguration.Builder(
            schema = setOf(Address::class, Course::class, Student::class, Teacher::class)
        ).build()
        return Realm.open(config)
    }
}