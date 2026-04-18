package com.app.easynotes.core

import android.content.Context
import androidx.room.Room
import com.app.easynotes.core.cache.CacheClient
import com.app.easynotes.core.cache.PrefClient
import com.app.easynotes.core.interceptors.AuthInterceptor
import com.app.easynotes.data.auth.datasource.local.AuthDao
import com.app.easynotes.data.auth.datasource.remote.AuthRemoteDataSource
import com.app.easynotes.data.auth.repository.AuthRepositoryImpl
import com.app.easynotes.data.notes.datasource.local.NotesLocalDataSource
import com.app.easynotes.data.notes.datasource.remote.NotesRemoteDataSource
import com.app.easynotes.data.notes.repository.NotesRepositoryImpl
import com.app.easynotes.domain.auth.repository.AuthRepository
import com.app.easynotes.domain.auth.usecase.FetchAuth
import com.app.easynotes.domain.auth.usecase.Login
import com.app.easynotes.domain.auth.usecase.Signup
import com.app.easynotes.domain.notes.repository.NotesRepository
import com.app.easynotes.domain.notes.usecase.CreateNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InjectionContainer {

    // Core
    @Provides
    @Singleton
    fun provideCacheClient(@ApplicationContext context: Context): CacheClient{
        return Room.databaseBuilder(context, CacheClient::class.java, "user_db").build()
    }

    @Provides
    @Singleton
    fun prefClientProvider(@ApplicationContext context: Context): PrefClient{
        return PrefClient(context)
    }

    @Provides
    @Singleton
    fun httpClientProvider(prefClient: PrefClient): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(
            AuthInterceptor(prefClient)
        ).build()
    }

    @Provides
    @Singleton
    fun provideApiClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().
        baseUrl(Constants.baseUrl).
        client(okHttpClient).
        addConverterFactory(GsonConverterFactory.create()).
        build()
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
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource, authDao: AuthDao, prefClient: PrefClient): AuthRepository{
        return AuthRepositoryImpl(authRemoteDataSource, authDao, prefClient)
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

    @Provides
    @Singleton
    fun fetchAuthProvider(authRepository: AuthRepository) : FetchAuth{
        return FetchAuth(authRepository = authRepository)
    }


    // Notes
    @Provides
    @Singleton
    fun provideNotesRemoteDataSource(retrofit: Retrofit): NotesRemoteDataSource{
        return retrofit.create(NotesRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideNotesLocalDataSource(cacheClient: CacheClient): NotesLocalDataSource{
        return cacheClient.provideNotesDao()
    }

    @Provides
    @Singleton
    fun provideNotesRspository(notesRemoteDataSource: NotesRemoteDataSource, notesLocalDataSource: NotesLocalDataSource) : NotesRepository{
        return NotesRepositoryImpl(notesRemoteDataSource, notesLocalDataSource)
    }

    @Provides
    @Singleton
    fun createNoteUseCaseProvider(notesRepository: NotesRepository): CreateNote{
        return CreateNote(notesRepository)
    }
}