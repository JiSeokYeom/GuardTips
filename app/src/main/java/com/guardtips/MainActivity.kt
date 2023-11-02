package com.guardtips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

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

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
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
                            }
                        }
                    )
                }
            }
        }
    }
}

