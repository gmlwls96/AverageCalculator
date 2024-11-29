package com.hj.average.core.datastore

import kotlinx.coroutines.flow.Flow

interface UserDataStore {
    fun getUserFlow(): Flow<UserPreferences>
    suspend fun updateUserName(userName: String)
}