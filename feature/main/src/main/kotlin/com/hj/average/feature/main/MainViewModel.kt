package com.hj.average.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hj.average.core.datastore.DataStoreManager
import com.hj.average.core.models.ThemeType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
) : ViewModel() {

    @Suppress("TooGenericExceptionCaught")
    val themeType = dataStoreManager.getFlowString(DataStoreManager.THEME_TYPE_KEY)
        .map {
            try {
                ThemeType.valueOf(it)
            } catch (e: Exception) {
                ThemeType.SYSTEM
            }
        }

    fun updateTheme(themeType: ThemeType) = viewModelScope.launch {
        dataStoreManager.updateStringValue(DataStoreManager.THEME_TYPE_KEY, themeType.name)
    }
}