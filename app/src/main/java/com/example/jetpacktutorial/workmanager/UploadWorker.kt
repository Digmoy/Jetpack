package com.example.jetpacktutorial.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.util.*

class UploadWorker(context: Context,params : WorkerParameters) : Worker(context,params) {

    override fun doWork(): Result {

        return try {
            val count = inputData.getInt(WorkManagerOneActivity.KEY_COUNT_VALUE,0)
            for (i in 0 until count) {
                Log.i("MyTag","upload $i")
            }
            val tz = TimeZone.getDefault()
            println(
                "TimeZone " + tz.getDisplayName(true, TimeZone.SHORT)
                    .toString() + " Timezone id :: " + tz.id
            )

            val outputData = Data.Builder().putString(KEY_WORKER,"TimeZone " + tz.getDisplayName(true, TimeZone.SHORT)
                .toString() + " Timezone id :: " + tz.id).build()

            Result.success(outputData)
        } catch (e : Exception) {
            Result.failure()
        }
    }

    companion object{
        const val KEY_WORKER = "kay_worker"
    }
}