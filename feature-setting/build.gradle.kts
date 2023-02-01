plugins {
    id("diary.android.library")
    id("diary.android.library.compose")
    id("diary.android.feature")
    id("diary.hilt")
}

dependencies {
    implementation(project("password"))
    implementation(project("delete-data"))
}