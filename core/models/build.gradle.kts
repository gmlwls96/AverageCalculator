plugins {
    id("template.android.library")
    id("kotlinx-serialization")
}

android {
    namespace = "com.hj.average.core.models"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.immutable)
}
