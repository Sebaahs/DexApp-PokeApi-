package com.sebaahs.dexapp.provider.core

import android.util.Log
import com.sebaahs.dexapp.util.ResourceStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall( call: suspend () -> T ) : ResourceStatus <T> = withContext(Dispatchers.IO) {
        try {
            ResourceStatus.Success(call())
        } catch (e : UnknownHostException) {
            ResourceStatus.Error("No internet connection")
        } catch (e : Exception) {
            Log.e("makeNetworkCall","Exception:$e")
            ResourceStatus.Error("Exception: ${e.message}")
        }
    }