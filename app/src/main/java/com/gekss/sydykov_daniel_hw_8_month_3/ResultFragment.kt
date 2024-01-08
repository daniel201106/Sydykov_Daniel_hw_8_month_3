package com.gekss.sydykov_daniel_hw_8_month_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.gekss.sydykov_daniel_hw_8_month_3.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val model = it.getSerializable("start") as Series
            binding.nameTv.text = model.name
            binding.statusTv.text = model.status
            Glide.with(binding.posterImg).load(model.img).into(binding.posterImg)
        }
    }
}