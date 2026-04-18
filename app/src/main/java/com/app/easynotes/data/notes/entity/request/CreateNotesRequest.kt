package com.app.easynotes.data.notes.entity.request

data class CreateNotesRequest(
    val userId: Int,
    val title: String,
    val description: String,
)