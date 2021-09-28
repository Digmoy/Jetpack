package com.example.jetpacktutorial.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.Constraints
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
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).setConstraints(constraints).build()
        WorkManager.getInstance(applicationContext).enqueue(uploadRequest)

        workManager.getWorkInfoByIdLiveData(uploadRequest.id).observe(this, Observer {
            binding.tvCount.text = it.state.name
        })
    }
}