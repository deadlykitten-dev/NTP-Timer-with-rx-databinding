package com.kestrel9.android.rxdatabindingntptimer.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kestrel9.android.rxdatabindingntptimer.R
import com.kestrel9.android.rxdatabindingntptimer.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel  by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun onResume() {
        super.onResume()
        binding.vm?.setTimer()
    }

    override fun onStop() {
        super.onStop()
        binding.vm?.stop()
    }

}
