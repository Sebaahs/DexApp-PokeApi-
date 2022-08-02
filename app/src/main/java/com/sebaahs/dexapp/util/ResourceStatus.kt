package com.sebaahs.dexapp.util

sealed class ResourceStatus <T> () {
    class Success<T>(val data: T): ResourceStatus<T>()
    class Loading <T> : ResourceStatus<T>()
    class Error<T>(val message: String): ResourceStatus<T>()
}