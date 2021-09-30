package com.example.jetpacktutorial.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityWorkManagerOneBinding

class WorkManagerOneActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding : ActivityWorkManagerOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_work_manager_one)

        binding.btnClick.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.btn_click ->{
                oneTimeWorkRequest()
            }
        }
    }
    private fun oneTimeWorkRequest(){
        val workManager : WorkManager = WorkManager.getInstance(applicationContext)

        val data = Data.Builder().putInt(KEY_COUNT_VALUE,125).build()

        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        val filterRequest = OneTimeWorkRequest.Builder(FilteringWorker::class.java).build()

        val compressRequest = OneTimeWorkRequest.Builder(CompressingWorker::class.java).build()

        WorkManager.getInstance(applicationContext)
            .beginWith(filterRequest)
            .then(compressRequest)
            .then(uploadRequest)
            .enqueue()

        workManager.getWorkInfoByIdLiveData(uploadRequest.id).observe(this, Observer {
            binding.tvCount.text = it.state.name

            if(it.state.isFinished)
            {
                val data = it.outputData
                val message = data.getString(UploadWorker.KEY_WORKER)
                Toast.makeText(this,message,Toast.LENGTH_LONG).show()
            }

        })
    }

    companion object{
        const val KEY_COUNT_VALUE = "key_count"
    }
}