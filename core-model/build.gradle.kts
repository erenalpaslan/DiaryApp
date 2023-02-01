plugins {
    id("diary.android.library")
    id("diary.hilt")
}
dependencies {
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)

    implementation(libs.gson)
}