plugins {
    id("diary.android.library")
    id("diary.hilt")
}

dependencies {
    api(libs.datastore.preferences)
    api(libs.datastore.core)
}