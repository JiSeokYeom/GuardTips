package com.guardtips

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.LoadingState
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.guardtips.compose_ui.MainBlueColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val webViewClient = AccompanistWebViewClient()
            val webChromeClient = AccompanistWebChromeClient()

            val webViewState =
                rememberWebViewState(
                    url = BuildConfig.BASE_URL,
                    additionalHttpHeaders = emptyMap()
                )
            val loadingState = webViewState.loadingState
            var isLoading by remember {
                mutableStateOf(true)
            }

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(75.dp)
                            .align(Alignment.Center),
                        color = MainBlueColor
                    )
                }
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        WebView(
                            state = webViewState,
                            client = webViewClient,
                            chromeClient = webChromeClient,
                            onCreated = { webView ->
                                with(webView) {
                                    settings.run {
                                        javaScriptEnabled = true
                                        domStorageEnabled = true
                                        javaScriptCanOpenWindowsAutomatically = false
                                    }

                                    setBackgroundColor(0x00000000)
                                    setLayerType(View.LAYER_TYPE_SOFTWARE, null)
                                }
                            }
                        )
                    }

                when(loadingState){
                    LoadingState.Finished -> {
                        isLoading = false
                    }

                    else -> Unit
                }
            }
        }
    }
}

