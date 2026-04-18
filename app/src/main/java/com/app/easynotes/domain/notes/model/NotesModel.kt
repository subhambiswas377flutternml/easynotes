package com.app.easynotes.domain.notes.model

data class NotesModel(
    val id: Int,
    val userId: Int,
    val title: String,
    val description: String,
)