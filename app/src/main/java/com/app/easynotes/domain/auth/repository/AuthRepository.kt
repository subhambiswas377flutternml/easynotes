package com.app.easynotes.domain.auth.repository
import com.app.easynotes.domain.auth.model.AuthModel

interface AuthRepository {
    suspend fun login(username: String, password:String): AuthModel
    suspend fun signup(name: String, username: String, password:String): Boolean
}