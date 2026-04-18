package com.app.easynotes.core.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.easynotes.data.auth.datasource.local.AuthDao
import com.app.easynotes.data.auth.entity.response.AuthCacheDto
import com.app.easynotes.data.notes.datasource.local.NotesLocalDataSource
import com.app.easynotes.data.notes.entity.response.NotesCacheDto

@Database(
    entities = [AuthCacheDto::class, NotesCacheDto::class],
    exportSchema = false,
    version = 1
)
abstract class CacheClient() : RoomDatabase() {
    abstract fun provideAuthDao(): AuthDao
    abstract fun provideNotesDao(): NotesLocalDataSource
}