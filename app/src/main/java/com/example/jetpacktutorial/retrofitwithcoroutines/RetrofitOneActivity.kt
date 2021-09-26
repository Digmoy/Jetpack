package com.example.jetpacktutorial.retrofitwithcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityRetrofitOneBinding
import com.example.jetpacktutorial.retrofitwithcoroutines.model.Photos
import retrofit2.Response

class RetrofitOneActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRetrofitOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_retrofit_one)

        val responseLiveData : LiveData<Response<List<Photos>>> = liveData {
            val response = RetrofitClient.apiInterface.getPhotos()
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val photoList = it.body()?.listIterator()
            if (photoList!=null){
                while (photoList.hasNext()){
                    val photoItems = photoList.next()
                    Log.i("MyTag",""+photoItems)
                    val result = "Title : "+photoItems.title+"\n\n"
                    binding.textView.append(result)
                }
            }
        })
    }
}