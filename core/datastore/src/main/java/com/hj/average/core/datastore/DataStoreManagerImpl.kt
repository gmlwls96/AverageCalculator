package com.hj.average.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class DataStoreManagerImpl(private val settingDataStore: DataStore<Preferences>) : DataStoreManager {

    override fun getFlowString(key: String): Flow<String> =
        settingDataStore
            .data
            .map { pref ->
                pref[stringPreferencesKey(key)] ?: ""
            }

    override fun getFlowInt(key: String): Flow<Int> =
        settingDataStore
            .data
            .map { pref ->
                pref[intPreferencesKey(key)] ?: -1
            }

    override fun getFlowBoolean(key: String): Flow<Boolean> =
        settingDataStore
            .data
            .map { pref ->
                pref[booleanPreferencesKey(key)] ?: false
            }

    override fun getDoubleBoolean(key: String): Flow<Double> =
        settingDataStore
            .data
            .map { pref ->
                pref[doublePreferencesKey(key)] ?: 0.0
            }

    override suspend fun updateStringValue(key: String, value: String) {
        settingDataStore
            .edit { settings ->
                settings[stringPreferencesKey(key)] = value
            }
    }

    override suspend fun updateIntValue(key: String, value: Int) {
        settingDataStore
            .edit { settings ->
                settings[intPreferencesKey(key)] = value
            }
    }

    override suspend fun updateBooleanValue(key: String, value: Boolean) {
        settingDataStore
            .edit { settings ->
                settings[booleanPreferencesKey(key)] = value
            }
    }

    override suspend fun updateDouble(key: String, value: Double) {
        settingDataStore
            .edit { settings ->
                settings[doublePreferencesKey(key)] = value
            }
    }

    override suspend fun clear() {
        settingDataStore
            .edit { settings ->
                settings.clear()
            }
    }
}