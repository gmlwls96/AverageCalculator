package com.hj.average.core.data.repository

import com.hj.average.core.data.Result
import com.hj.average.core.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getRemoteUser(userName: String): Flow<Result<User>>
    fun getLocalUserName(): Flow<User>
    suspend fun updateLocalUserName(userName: String)
}