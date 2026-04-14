package com.app.easynotes.core

import android.content.Context
import androidx.room.Room
import com.app.easynotes.core.cache.CacheClient
import com.app.easynotes.data.auth.datasource.local.AuthDao
import com.app.easynotes.data.auth.datasource.remote.AuthRemoteDataSource
import com.app.easynotes.data.auth.repository.AuthRepositoryImpl
import com.app.easynotes.domain.auth.repository.AuthRepository
import com.app.easynotes.domain.auth.usecase.Login
import com.app.easynotes.domain.auth.usecase.Signup
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InjectionContainer {

    @Provides
    @Singleton
    fun provideApiClient(): Retrofit {
        return Retrofit.Builder().
        baseUrl(Constants.baseUrl).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    @Provides
    @Singleton
    fun provideCacheClient(@ApplicationContext context: Context): CacheClient{
        return Room.databaseBuilder(context, CacheClient::class.java, "user_db").build()
    }

    // Remote-Data-Source
    @Provides
    @Singleton
    fun provideAuthRemoteDataSource(retrofit: Retrofit): AuthRemoteDataSource{
        return retrofit.create(AuthRemoteDataSource::class.java)
    }

    // Local-Data-Source
    @Provides
    @Singleton
    fun provideAuthLocalDataSource(cacheClient: CacheClient): AuthDao{
        return cacheClient.provideAuthDao()
    }

    // Repository
    @Provides
    @Singleton
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource, authDao: AuthDao): AuthRepository{
        return AuthRepositoryImpl(authRemoteDataSource, authDao)
    }

    // UseCase
    @Provides
    @Singleton
    fun loginUseCaseProvider(authRepository: AuthRepository): Login{
        return Login(authRepository)
    }

    @Provides
    @Singleton
    fun signupUseCaseProvider(authRepository: AuthRepository): Signup{
        return Signup(authRepository)
    }
}