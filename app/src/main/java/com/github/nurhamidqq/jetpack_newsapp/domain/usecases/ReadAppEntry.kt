package com.github.nurhamidqq.jetpack_newsapp.domain.usecases

import com.github.nurhamidqq.jetpack_newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}