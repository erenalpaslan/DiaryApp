plugins {
    id("diary.android.library")
    id("diary.hilt")
}

dependencies {
    implementation(libs.datastore.preferences)
    implementation(libs.datastore.core)
}