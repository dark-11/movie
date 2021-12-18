package com.example.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.base.BaseActivity
import com.example.delegates.MainViewModelDelegate
import com.example.movie.R
import com.example.movie.databinding.ActivityMainBinding
import com.example.utility.BottomSheet
import com.example.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity(), MainViewModelDelegate {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModel: MainViewModel
    @Inject
    lateinit var bottomSheet: BottomSheet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.viewModel = viewModel
        viewModel.delegate = this
        bottomSheet.init(this)
    }


    override fun onResume() {
        super.onResume()
        viewModel.init()
    }


    override fun showBottomSheet() {
        bottomSheet.show()
    }
}