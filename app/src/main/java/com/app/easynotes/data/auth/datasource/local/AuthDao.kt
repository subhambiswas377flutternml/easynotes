package com.app.easynotes.data.auth.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.easynotes.data.auth.entity.response.AuthCacheDto
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(authCacheDto: AuthCacheDto)

    @Query("Select * from `user_table`")
    fun getAll(): Flow<AuthCacheDto>

    @Update
    suspend fun update(authCacheDto: AuthCacheDto)

    @Delete
    suspend fun delete(authCacheDto: AuthCacheDto)
}