package com.app.easynotes.data.notes.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.app.easynotes.data.notes.entity.response.NotesCacheDto
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesLocalDataSource {
    @Upsert
    suspend fun upsertNote(notes: List<NotesCacheDto>)

    @Query("Select * from `notes_table`")
    fun getAllNotes(): Flow<List<NotesCacheDto>>

    @Delete
    suspend fun deleteNote(notesCacheDto: NotesCacheDto)
}