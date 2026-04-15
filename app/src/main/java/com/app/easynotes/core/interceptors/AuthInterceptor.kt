package com.app.easynotes.core.interceptors

import com.app.easynotes.core.cache.PrefClient
import com.app.easynotes.core.needsAuthentication
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val prefClient: PrefClient) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response{
        val request = chain.request().newBuilder()
        val requestUrl = chain.request().url.toString()

        if(requestUrl.needsAuthentication()){
            val authToken: String? = prefClient.accessToken
            request.addHeader("Authorization", "Bearer $authToken")
        }

        return chain.proceed(request.build())
    }
}