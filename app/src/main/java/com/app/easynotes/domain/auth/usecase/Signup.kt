package com.app.easynotes.domain.auth.usecase

import com.app.easynotes.domain.auth.repository.AuthRepository

class Signup(private val authRepository: AuthRepository) {
    suspend operator fun invoke(name: String, username: String, password: String): Boolean{
        return authRepository.signup(name, username, password)
    }
}