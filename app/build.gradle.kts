plugins {
    id("diary.android.application")
    id("diary.android.application.compose")
    id("diary.hilt")
}

android {
    namespace = "com.easylife.diary"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.easylife.diary"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)

    //region Features
    implementation(project(":feature-splash"))
    implementation(project(":feature-theme"))
    implementation(project(":feature-note"))
    implementation(project(":feature-diary"))
    implementation(project(":feature-calendar"))
    implementation(project(":feature-insight"))
    implementation(project(":feature-setting"))
    //endregion

    //region Cores
    implementation(project(":core-designsystem"))
    implementation(project(":core-preferences"))
    implementation(project(":core-navigation"))
    //endregion

    //region Accompanist
    implementation(libs.accompanist.navigation.animation)
    //endregion

    //region Datastore
    implementation(libs.datastore.core)
    implementation(libs.datastore.preferences)
    //endregion

    //region Networking
    implementation(libs.gson)
    val okhttpBom = platform(libs.okhttp.bom)
    implementation(okhttpBom)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson.converter)
    implementation(libs.retrofit.coroutine.adapter)
    //endregion
}