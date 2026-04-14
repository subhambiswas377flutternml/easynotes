package com.app.easynotes.domain.auth.model

data class AuthModel(
    val id: Int,
    val name: String,
    val username: String,
    val accessToken: String
)