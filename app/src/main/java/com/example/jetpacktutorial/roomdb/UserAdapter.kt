package com.example.jetpacktutorial.roomdb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ListItemBinding
import com.example.jetpacktutorial.generated.callback.OnClickListener
import com.example.jetpacktutorial.roomdb.model.User

class UserAdapter(private val users : List<User>,private val clickListener: (User)->Unit) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {


    inner class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(user : User,clickListener: (User)->Unit){
            binding.tvName.text = user.name
            binding.tvEmail.text = user.email
            binding.listItemLayout.setOnClickListener {
                clickListener(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : ListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(users[position],clickListener)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
