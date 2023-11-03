package com.guardtips.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.guardtips.MainActivity
import com.guardtips.base.BaseViewBindingActivity
import com.guardtips.databinding.ActivitySplashBinding
import com.guardtips.extensions.launchActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity: BaseViewBindingActivity<ActivitySplashBinding>() {


    val coroutineScope by lazy { CoroutineScope(Dispatchers.Main) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coroutineScope.launch {
            delay(1800)
            launchActivity<MainActivity>{
                finish()
            }
        }

    }

    override val bindingInflater: (LayoutInflater) -> ActivitySplashBinding
        get() = ActivitySplashBinding::inflate
}