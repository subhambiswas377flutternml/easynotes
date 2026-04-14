package com.app.easynotes.core

data class ResponseWrapper<T>(
    val data: T,
    val message: String,
    val success: Boolean
)