package com.app.easynotes.data.notes.repository

import com.app.easynotes.data.notes.datasource.local.NotesLocalDataSource
import com.app.easynotes.data.notes.datasource.remote.NotesRemoteDataSource
import com.app.easynotes.data.notes.entity.request.CreateNotesRequest
import com.app.easynotes.data.notes.entity.response.toCacheDto
import com.app.easynotes.data.notes.entity.response.toModel
import com.app.easynotes.domain.notes.model.NotesModel
import com.app.easynotes.domain.notes.repository.NotesRepository

class NotesRepositoryImpl(
    private val notesRemoteDataSource: NotesRemoteDataSource,
    private val notesLocalDataSource: NotesLocalDataSource,
) : NotesRepository {
    override suspend fun createNote(createNotesRequest: CreateNotesRequest): List<NotesModel>{
        try{
            val response = notesRemoteDataSource.createNote(createNotesRequest)
            if(response.success){
                notesLocalDataSource.upsertNote(response.data.map { it-> it.toCacheDto() }.toList())
                return response.data.map { it-> it.toCacheDto().toModel() }.toList()
            }else{
                throw Exception(message = "Api Failure")
            }
        }catch(ex: Exception){
            throw ex
        }
    }
}