package com.example.jetpacktutorial.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityRoomOneBinding
import com.example.jetpacktutorial.roomdb.db.UserDatabase
import com.example.jetpacktutorial.roomdb.model.User

class RoomOneActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRoomOneBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_room_one)

        val dao = UserDatabase.getInstance(application).userDAO
        val repository = UserRepository(dao)
        val factory = UserViewModelFactory(repository)
        viewModel = ViewModelProvider(this,factory)[UserViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        initRecyclerView()

        viewModel.massage.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun initRecyclerView(){
        binding.recUser.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter { selectedItem: User ->listItemClicked(selectedItem) }
        binding.recUser.adapter = adapter
        displayUserList()
    }

    private fun displayUserList(){
        viewModel.users.observe(this, Observer {
            Log.i("MyTag",it.toString())
            adapter.setList(it)
            adapter.notifyDataSetChanged()

        })
    }

    private fun listItemClicked(user : User){
        Toast.makeText(this,"selected name is ${user.name}",Toast.LENGTH_LONG).show()
        viewModel.initUpdateAndDelete(user)
    }
}