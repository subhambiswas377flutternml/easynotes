package com.app.easynotes.core

object DimensConfiguration {


    var scaleHeight: Float = 1f
    var scaleWidth: Float = 1f

    fun initConfiguration(deviceHeight: Int, deviceWidth: Int){
        scaleHeight = deviceHeight.toFloat() / AppConstants.designHeight
        scaleWidth = deviceWidth.toFloat() / AppConstants.designWidth
    }
}

val Int.h: Float
    get(){
        return DimensConfiguration.scaleHeight * this
    }

val Int.w: Float
    get(){
        return DimensConfiguration.scaleWidth * this
    }

val Double.h: Double
    get(){
        return DimensConfiguration.scaleHeight * this
    }

val Double.w: Double
    get(){
        return DimensConfiguration.scaleWidth * this
    }