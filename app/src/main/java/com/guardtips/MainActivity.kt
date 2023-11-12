package com.guardtips

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.JavascriptInterface
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.LoadingState
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.guardtips.compose_ui.MainBlueColor

@SuppressLint("SetJavaScriptEnabled")
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
                                    addJavascriptInterface(
                                        JavascriptBridge(this@MainActivity),
                                        "Android"
                                    )
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

    class JavascriptBridge(private val context: Context) {
        @JavascriptInterface
        fun getType(type: String) {
            Log.d("테스", type)
            Toast.makeText(context, type, Toast.LENGTH_LONG).show()
        }
    }
}

