package com.app.easynotes.data.notes.entity.response

data class NotesEntity(
    val id: Int,
    val userId: Int,
    val title: String,
    val description: String,
)

fun NotesEntity.toCacheDto(): NotesCacheDto {
    return NotesCacheDto(
        id = id,
        userId = userId,
        title = title,
        description = description,
    )
}