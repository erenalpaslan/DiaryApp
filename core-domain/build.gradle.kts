plugins {
    id("diary.android.library")
    id("diary.hilt")
}

dependencies {
    implementation(project(":core-model"))
    implementation(project(":core-common"))
    implementation(project(":core-data"))
}