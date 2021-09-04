package com.example.jetpacktutorial.coroutine

import kotlinx.coroutines.*

class UserUnStructured {
    var count = 0
    suspend fun getTotalUserCount() : Int{

        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        }

       val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }

        return count + deferred.await()
    }


}