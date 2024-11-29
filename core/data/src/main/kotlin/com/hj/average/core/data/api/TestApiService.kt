package com.hj.average.core.data.api

import com.hj.average.core.models.User
import com.hj.average.core.network.NetworkResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TestApiService {

    @GET("/v2/search/user")
    suspend fun getUser(
        @Query("name") name: String,
    ): NetworkResult<User>
}