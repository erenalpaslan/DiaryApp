plugins {
    id("diary.android.library")
    id("diary.hilt")
    id("diary.android.library.compose")
}

dependencies {
    implementation(project(":core-navigation"))
    implementation(project(":core-model"))
    implementation(libs.core.ktx)
    implementation(libs.androidx.livedata)
}