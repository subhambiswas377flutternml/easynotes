package com.app.easynotes.data.notes.entity.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.easynotes.domain.notes.model.NotesModel

@Entity(tableName = "notes_table")
data class NotesCacheDto(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo
    val userId: Int,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val description: String,
)

fun NotesCacheDto.toModel(): NotesModel{
    return NotesModel(
        id = id,
        userId = userId,
        title = title,
        description = description,
    )
}