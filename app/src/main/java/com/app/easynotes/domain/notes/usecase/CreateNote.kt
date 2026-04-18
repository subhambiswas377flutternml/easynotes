package com.app.easynotes.domain.notes.usecase

import com.app.easynotes.data.notes.entity.request.CreateNotesRequest
import com.app.easynotes.domain.notes.model.NotesModel
import com.app.easynotes.domain.notes.repository.NotesRepository

class CreateNote(private val notesRepository: NotesRepository) {
    suspend operator fun invoke(createNotesRequest: CreateNotesRequest): List<NotesModel>{
        return notesRepository.createNote(createNotesRequest)
    }
}