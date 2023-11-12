object Libs {

    object Androidx {
        const val core = "androidx.core:core-ktx:1.12.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        const val cardView = "androidx.cardview:cardview:1.0.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.1"
        const val viewpager = "androidx.viewpager2:viewpager2:1.0.0"
        const val preference = "androidx.preference:preference:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val activityKtx = "androidx.activity:activity-ktx:1.4.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.4"
        const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.4.2"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:2.4.2"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.2.0-alpha01"
        const val window = "androidx.window:window:1.1.0-alpha06"


        object Compose {
            const val bom = "androidx.compose:compose-bom:2023.01.00"
            const val ui = "androidx.compose.ui:ui"
            const val tooling = "androidx.compose.ui:ui-tooling"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview"
            const val foundation = "androidx.compose.foundation:foundation"
            const val material = "androidx.compose.material:material"
            const val materialIconsCore = "androidx.compose.material:material-icons-core"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended"
            const val uiTest = "androidx.compose.ui:ui-test-junit4"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata"
            const val webView = "com.google.accompanist:accompanist-webview:0.31.4-beta"
        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.6.1"
        }

        object Coroutine {
            private const val coroutineVersion = "2.6.2"

            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$coroutineVersion"
            const val runTime = "androidx.lifecycle:lifecycle-runtime-ktx:$coroutineVersion"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$coroutineVersion"
        }

        object Lifecycle {
            private const val version = "2.5.1"

            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        }

    }

    object Firebase {
        const val bom = "com.google.firebase:firebase-bom:32.0.0"
        const val analytics = "com.google.firebase:firebase-analytics"
    }

    object Ui {
        const val lottie = "com.airbnb.android:lottie:5.2.0"
    }

}