package com.example.jetpacktutorial.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R

import com.example.jetpacktutorial.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding : FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        var input : String? = requireArguments().getString("user_input")
        var title : String? = requireArguments().getString("title")
        binding.tvName.text = "Fragment Two $input $title"
        return binding.root
    }

}