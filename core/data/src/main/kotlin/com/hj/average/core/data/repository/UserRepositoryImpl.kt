package com.hj.average.core.data.repository

import com.hj.average.core.data.Result
import com.hj.average.core.data.api.TestApiService
import com.hj.average.core.data.asResult
import com.hj.average.core.datastore.UserDataStore
import com.hj.average.core.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val apiService: TestApiService,
    private val userDataStore: UserDataStore,
) : UserRepository {

    override suspend fun getRemoteUser(userName: String): Flow<Result<User>> =
        flowOf(
            apiService
                .getUser(userName)
                .asResult { it }
        )

    override fun getLocalUserName(): Flow<User> =
        userDataStore
            .getUserFlow()
            .map {
                User(it.name)
            }

    override suspend fun updateLocalUserName(userName: String) =
        userDataStore.updateUserName(userName)
}