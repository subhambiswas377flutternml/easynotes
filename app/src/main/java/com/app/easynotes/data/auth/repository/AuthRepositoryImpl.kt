package com.app.easynotes.data.auth.repository

import com.app.easynotes.core.AppConstants
import com.app.easynotes.core.ResponseWrapper
import com.app.easynotes.core.cache.PrefClient
import com.app.easynotes.data.auth.datasource.local.AuthDao
import com.app.easynotes.data.auth.datasource.remote.AuthRemoteDataSource
import com.app.easynotes.data.auth.entity.request.LoginRequestDto
import com.app.easynotes.data.auth.entity.request.SignupRequestDto
import com.app.easynotes.data.auth.entity.response.AuthCacheDto
import com.app.easynotes.data.auth.entity.response.AuthEntity
import com.app.easynotes.data.auth.entity.response.toCacheDto
import com.app.easynotes.data.auth.entity.response.toModel
import com.app.easynotes.domain.auth.model.AuthModel
import com.app.easynotes.domain.auth.repository.AuthRepository
import kotlinx.coroutines.flow.first

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource,
                         private val authDao: AuthDao,
                         private val prefClient: PrefClient): AuthRepository {
    override suspend fun login(username: String, password: String): AuthModel {
        val response: ResponseWrapper<AuthEntity> = authRemoteDataSource.login(LoginRequestDto(username, password))
        if(response.success){
            authDao.insert(response.data.toCacheDto())
            prefClient.saveData(key = AppConstants.accessTokenKey, dataValue = response.data.accessToken)
            prefClient.fetchAccessToken()
            return response.data.toCacheDto().toModel()
        }else{
            throw Exception()
        }
    }

    override suspend fun signup(name: String, username: String, password: String): Boolean {
        val response: ResponseWrapper<Boolean>  = authRemoteDataSource.signup(SignupRequestDto(name,username,password))
        return response.data
    }

    override suspend fun fetchAuth(): AuthModel{
        val result: AuthCacheDto = authDao.getAll().first()
        prefClient.fetchAccessToken()
        return result.toModel()
    }
}