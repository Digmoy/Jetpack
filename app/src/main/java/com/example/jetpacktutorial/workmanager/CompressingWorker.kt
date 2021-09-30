package com.example.jetpacktutorial.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class CompressingWorker (context: Context, params : WorkerParameters) : Worker(context,params) {
    override fun doWork(): Result {

        return try {
            for (i in 0..500) {
                Log.i("MyTag", "Compress $i")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}