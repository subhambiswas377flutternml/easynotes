package com.app.easynotes.domain.auth.usecase

import com.app.easynotes.domain.auth.model.AuthModel
import com.app.easynotes.domain.auth.repository.AuthRepository

class Login(private val authRepository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String): AuthModel{
        return authRepository.login(username, password)
    }
}