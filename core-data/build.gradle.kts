plugins {
    id("diary.android.library")
    id("diary.hilt")
}

dependencies {
    implementation(project(":core-model"))
    implementation(project(":core-common"))

    implementation(libs.gson)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)
}