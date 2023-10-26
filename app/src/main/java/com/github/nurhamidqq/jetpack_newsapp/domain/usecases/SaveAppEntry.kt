package com.github.nurhamidqq.jetpack_newsapp.domain.usecases

import com.github.nurhamidqq.jetpack_newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}