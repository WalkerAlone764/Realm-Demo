package com.example.realm_demo.di

import com.example.realm_demo.data.repository.MongoRepositoryImpl
import com.example.realm_demo.domain.repository.MongoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRealm(): MongoRepository {
        return MongoRepositoryImpl()
    }

}