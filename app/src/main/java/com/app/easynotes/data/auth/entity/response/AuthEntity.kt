package com.app.easynotes.data.auth.entity.response

data class AuthEntity(
    val id: Int,
    val name: String,
    val username: String,
    val accessToken: String
)

fun AuthEntity.toCacheDto(): AuthCacheDto {
    return AuthCacheDto(
        id = this.id,
        name=this.name,
        username=this.username,
        accessToken=this.accessToken
    )
}