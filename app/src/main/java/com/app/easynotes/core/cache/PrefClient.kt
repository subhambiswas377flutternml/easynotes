package com.app.easynotes.core.cache

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.app.easynotes.core.AppConstants
import kotlinx.coroutines.flow.first

class PrefClient(private val context: Context) {
    val Context.dataStore by preferencesDataStore(AppConstants.dataStoreKey)

    // Quick Access L1 Cache
    var accessToken: String? = null

    suspend fun saveData(key: String, dataValue: String){
        context.dataStore.edit { prefInstance->
            prefInstance[stringPreferencesKey(key)] = dataValue
        }
    }

    suspend fun getData(key: String): String? {
        return context.dataStore.data.first()[stringPreferencesKey(key)]
    }

    // L1 Cache Fetchers
    suspend fun fetchAccessToken(){
        accessToken = context.dataStore.data.first()[stringPreferencesKey(AppConstants.accessTokenKey)]
    }
}