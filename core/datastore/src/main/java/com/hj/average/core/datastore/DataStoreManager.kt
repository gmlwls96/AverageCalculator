package com.hj.average.core.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    fun getFlowInt(key: String): Flow<Int>
    fun getFlowString(key: String): Flow<String>
    fun getFlowBoolean(key: String): Flow<Boolean>
    fun getDoubleBoolean(key: String): Flow<Double>

    suspend fun updateStringValue(key: String, value: String)
    suspend fun updateIntValue(key: String, value: Int)
    suspend fun updateBooleanValue(key: String, value: Boolean)
    suspend fun updateDouble(key: String, value: Double)
    suspend fun clear()
}