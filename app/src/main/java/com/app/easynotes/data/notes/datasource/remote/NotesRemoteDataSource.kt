package com.app.easynotes.data.notes.datasource.remote

import com.app.easynotes.core.EndPoints
import com.app.easynotes.core.ResponseWrapper
import com.app.easynotes.data.notes.entity.request.CreateNotesRequest
import com.app.easynotes.data.notes.entity.response.NotesEntity
import retrofit2.http.Body
import retrofit2.http.POST

interface NotesRemoteDataSource {
    @POST(EndPoints.createNote)
    suspend fun createNote(@Body createNotesRequest: CreateNotesRequest): ResponseWrapper<List<NotesEntity>>
}