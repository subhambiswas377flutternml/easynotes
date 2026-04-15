package com.app.easynotes.domain.auth.usecase

import com.app.easynotes.domain.auth.model.AuthModel
import com.app.easynotes.domain.auth.repository.AuthRepository

class FetchAuth(private val authRepository: AuthRepository) {
    suspend operator fun invoke(): AuthModel{
        return authRepository.fetchAuth()
    }
}