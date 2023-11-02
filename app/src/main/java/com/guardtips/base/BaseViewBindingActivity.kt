package com.guardtips.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: ViewBinding? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    private val onBackPressedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            onBackPressedCallback()
        }
    }

    abstract val bindingInflater: (LayoutInflater) -> VB

    private fun bindView() {
        _binding = bindingInflater.invoke(layoutInflater)
    }

    fun setContentView() {
        setContentView(_binding?.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        bindView()
        setContentView()
        super.onCreate(savedInstanceState)
        addOnBackPressedCallback()
    }
    open fun onBackPressedCallback(){
        finish()
    }

    private fun addOnBackPressedCallback() {
        this.onBackPressedDispatcher.addCallback(this,onBackPressedCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}