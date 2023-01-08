plugins {
    id("diary.android.library")
}

dependencies {
    implementation(project(":core-model"))
    implementation(libs.core.ktx)
    implementation(libs.androidx.livedata)
}