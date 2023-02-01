plugins {
    id("diary.android.library")
    id("diary.hilt")
    id("diary.android.library.compose")
}
dependencies {
    implementation(libs.gson)
    implementation(libs.androidx.lifecycle.livedata)
}