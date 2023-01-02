plugins {
    id("diary.android.library")
    id("diary.android.library.compose")
    id("diary.android.feature")
    id("diary.hilt")
}

dependencies {
    implementation(project("feature-diary"))
    implementation(project("feature-calendar"))
    implementation(project("feature-insight"))
    implementation(project("feature-setting"))

}