package com.example.jetpacktutorial.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class FilteringWorker(context: Context, params : WorkerParameters) : Worker(context,params){
    override fun doWork(): Result {

        return try {
            for (i in 0..5000) {
                Log.i("MyTag","Filter $i")
            }
            Result.success()
        } catch (e : Exception) {
            Result.failure()
        }
    }
}