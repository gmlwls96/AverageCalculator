package com.hj.average.core.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException

internal class UserDataStoreImpl(private val userPreferences: DataStore<UserPreferences>) :
    UserDataStore {
    override fun getUserFlow(): Flow<UserPreferences> = userPreferences.data
        .catch { exception ->
            if (exception is IOException) {
                emit(UserPreferences.getDefaultInstance())
            } else {
                throw exception
            }
        }

    override suspend fun updateUserName(userName: String) {
        userPreferences.updateData {
            it.toBuilder().setName(userName).build()
        }
    }
}