package com.app.easynotes.core

class EndPoints {
    companion object{
        // Auth
        const val login: String = "/auth/login"
        const val signup: String = "/auth/signup"

        // Notes
        const val createNote: String = "/notes/create"
    }
}

fun String.needsAuthentication(): Boolean{
    if(contains(EndPoints.login)||
        contains(EndPoints.signup)){
        return false
    }else{
        return true
    }
}