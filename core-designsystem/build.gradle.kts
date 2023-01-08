plugins {
    id("diary.android.library")
    id("diary.hilt")
    id("diary.android.library.compose")
}

dependencies {
    implementation(project(":core-navigation"))

    val composeBom = platform(libs.androidx.compose.bom)
    api(composeBom)
    api(libs.androidx.activity.compose)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3.windowSizeClass)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.runtime.tracing)
    api(libs.androidx.compose.runtime.livedata)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.lifecycle.runtime.compose)
    api(libs.androidx.compose.constraintlayout)
    api(libs.androidx.compose.ui.util)

    api(libs.accompanist.pager)
    api(libs.accompanist.pager.indicators)
    api(libs.accompanist.navigation.animation)

    api(libs.coil)
    api(libs.gson)
}