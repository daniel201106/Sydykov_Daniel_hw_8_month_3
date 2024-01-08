package com.gekss.sydykov_daniel_hw_8_month_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.gekss.sydykov_daniel_hw_8_month_3.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val seriesList = arrayListOf(
        Series("https://pyxis.nymag.com/v1/imgs/3b7/ca7/5fd3353737d602a5a1caa3fce92cb33b39-rick-morty.1x.rsquare.w1400.jpg","Alive","Rick Sanchez"),
        Series("https://static.wikia.nocookie.net/rickandmorty/images/3/3e/Evil_Morty_Unmortricken.jpg/revision/latest?cb=20231114234616","Alive","Morty Smith"),
        Series("https://static.wikia.nocookie.net/rickandmorty/images/b/bc/Albert_Einstein.png/revision/latest?cb=20150730213810","Dad","Albert Einstein"),
        Series("https://static.wikia.nocookie.net/rickandmorty/images/f/f1/Jerry_Smith.png/revision/latest?cb=20160923151111","Alive","Jarry Smith")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = SeriesAdapter(seriesList, this::onClick)
        binding.posterRv.adapter = adapter
    }

    private fun onClick(model: Series) {
        findNavController().navigate(R.id.resultFragment, bundleOf("start" to model))
    }
}