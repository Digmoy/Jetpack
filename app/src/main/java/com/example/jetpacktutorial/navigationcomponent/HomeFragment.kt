package com.example.jetpacktutorial.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.btnNext.setOnClickListener {

            val bundle : Bundle = bundleOf("user_input" to "Digmoy","title" to "Saha")
            it.findNavController().navigate(R.id.action_homeFragment_to_SecondFragment,bundle)
        }
        return binding.root
    }

}