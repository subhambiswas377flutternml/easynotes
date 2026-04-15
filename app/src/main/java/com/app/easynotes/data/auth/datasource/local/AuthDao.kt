package com.app.easynotes.data.auth.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.app.easynotes.data.auth.entity.response.AuthCacheDto
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthDao {
    @Upsert
    suspend fun insert(authCacheDto: AuthCacheDto)

    @Query("Select * from `user_table`")
    fun getAll(): Flow<AuthCacheDto>

    @Delete
    suspend fun delete(authCacheDto: AuthCacheDto)
}