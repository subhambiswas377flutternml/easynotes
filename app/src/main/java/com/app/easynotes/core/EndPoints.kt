package com.app.easynotes.core

class EndPoints {
    companion object{
        const val login: String = "/auth/login"
        const val signup: String = "/auth/signup"
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