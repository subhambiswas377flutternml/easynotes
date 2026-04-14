package com.app.easynotes.data.auth.datasource.remote

import com.app.easynotes.core.ResponseWrapper
import com.app.easynotes.data.auth.entity.request.LoginRequestDto
import com.app.easynotes.data.auth.entity.request.SignupRequestDto
import com.app.easynotes.data.auth.entity.response.AuthEntity
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthRemoteDataSource {
    @POST("/auth/signup")
    suspend fun signup(@Body signupRequestDto: SignupRequestDto): ResponseWrapper<Boolean>

    @POST("/auth/login")
    suspend fun login(@Body loginRequestDto: LoginRequestDto): ResponseWrapper<AuthEntity>
}