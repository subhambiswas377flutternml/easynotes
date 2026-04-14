package com.app.easynotes.data.auth.entity.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.easynotes.domain.auth.model.AuthModel

@Entity(tableName = "user_table")
data class AuthCacheDto(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val username: String,
    @ColumnInfo
    val accessToken: String
)

fun AuthCacheDto.toModel(): AuthModel{
    return AuthModel(
        id = this.id,
        name = this.name,
        username = this.username,
        accessToken = this.accessToken
    )
}