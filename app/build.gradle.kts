plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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

    //region Compose

    //endregion

    //region Koin
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

    //region Coil
    //endregion

    /*implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
    implementation 'androidx.compose.material3:material3:1.1.0-alpha03'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.0'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
    debugImplementation "androidx.compose.ui:ui-test-manifest:$compose_version"*/
}