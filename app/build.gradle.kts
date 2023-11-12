plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.guardtips"
    compileSdk = SdkVersions.compileSdk

    defaultConfig {
        applicationId = "com.guardtips"
        minSdk = SdkVersions.minSdk
        targetSdk = SdkVersions.targetSdk
        versionCode = AppVersions.androidVersionCode
        versionName = AppVersions.androidVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            buildConfigField("String", "BASE_URL", "${project.properties["base_url"]}")

            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        release {
            isMinifyEnabled = false
            buildConfigField("String", "BASE_URL", "${project.properties["base_url"]}")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0-alpha01"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }
}


dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    api(Libs.Androidx.core)
    api(Libs.Androidx.appcompat)
    api(Libs.Androidx.cardView)
    api(Libs.Androidx.preference)
    api(Libs.Androidx.viewpager)
    api(Libs.Androidx.recyclerview)
    api(Libs.Androidx.coreKtx)
    api(Libs.Androidx.activityKtx)
    api(Libs.Androidx.fragmentKtx)
    api(Libs.Androidx.navigationFragmentKtx)
    api(Libs.Androidx.navigationUiKtx)
    api(Libs.Androidx.constraintlayout)
    api(Libs.Androidx.window)

    api(platform(Libs.Androidx.Compose.bom))
    api(Libs.Androidx.Compose.ui)
    api(Libs.Androidx.Compose.tooling)
    api(Libs.Androidx.Compose.toolingPreview)
    api(Libs.Androidx.Compose.foundation)
    api(Libs.Androidx.Compose.material)
    api(Libs.Androidx.Compose.materialIconsCore)
    api(Libs.Androidx.Compose.materialIconsExtended)
    api(Libs.Androidx.Compose.uiTest)
    api(Libs.Androidx.Compose.runtimeLivedata)
    api(Libs.Androidx.Compose.webView)

    api(platform(Libs.Firebase.bom))
    api(Libs.Firebase.analytics)

    api(Libs.Androidx.Coroutine.runTime)
    api(Libs.Androidx.Coroutine.viewModel)
    api(Libs.Androidx.Coroutine.liveData)

    api(Libs.Androidx.Lifecycle.viewModelCompose)

    api(Libs.Androidx.Activity.activityCompose)

    api(Libs.Ui.lottie)
}
