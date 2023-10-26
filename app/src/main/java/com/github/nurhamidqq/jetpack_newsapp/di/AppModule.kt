package com.github.nurhamidqq.jetpack_newsapp.di

import android.app.Application
import com.github.nurhamidqq.jetpack_newsapp.data.manager.LocalUserManagerImpl
import com.github.nurhamidqq.jetpack_newsapp.domain.manager.LocalUserManager
import com.github.nurhamidqq.jetpack_newsapp.domain.usecases.AppEntryUsecases
import com.github.nurhamidqq.jetpack_newsapp.domain.usecases.ReadAppEntry
import com.github.nurhamidqq.jetpack_newsapp.domain.usecases.SaveAppEntry
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
    fun provideLocalUserManager(
        application:Application
    ):LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUsecases(
        localUserManager: LocalUserManager
    ) = AppEntryUsecases(readAppEntry = ReadAppEntry(localUserManager), saveAppEntry = SaveAppEntry(localUserManager))
}