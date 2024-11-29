package com.hj.average.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.hj.average.core.datastore.UserPreferences
import com.hj.average.core.datastore.serializer.UserPreferencesSerializer

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = KEY_PREF_DATA_STORE_SETTINGS)
    private val Context.userPreferencesStore: DataStore<UserPreferences> by dataStore(
        fileName = KEY_PREF_USER,
        serializer = UserPreferencesSerializer
    )

    @Provides
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager =
        DataStoreManagerImpl(context.dataStore)

    @Provides
    fun provideUserDataStore(@ApplicationContext context: Context): UserDataStore =
        UserDataStoreImpl(context.userPreferencesStore)

    companion object {
        private const val KEY_PREF_DATA_STORE_SETTINGS = "SETTINGS"
        private const val KEY_PREF_USER = "USER"
    }
}