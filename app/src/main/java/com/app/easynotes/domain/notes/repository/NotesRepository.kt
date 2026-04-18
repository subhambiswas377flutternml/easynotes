package com.app.easynotes.domain.notes.repository

import com.app.easynotes.data.notes.entity.request.CreateNotesRequest
import com.app.easynotes.domain.notes.model.NotesModel

interface NotesRepository {
    suspend fun createNote(createNotesRequest: CreateNotesRequest): List<NotesModel>
}