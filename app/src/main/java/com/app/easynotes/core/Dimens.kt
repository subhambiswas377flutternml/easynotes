package com.app.easynotes.core

object DimensConfiguration {


    var scaleHeight: Int = 0
    var scaleWidth: Int = 0

    fun initConfiguration(deviceHeight: Int, deviceWidth: Int){
        scaleHeight = deviceHeight / AppConstants.designHeight
        scaleWidth = deviceWidth / AppConstants.designWidth
    }
}

val Int.h: Int
    get(){
        return DimensConfiguration.scaleHeight * this
    }

val Int.w: Int
    get(){
        return DimensConfiguration.scaleWidth * this
    }