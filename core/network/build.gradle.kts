@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    id("template.android.library")
    alias(libs.plugins.secrets)
}

android {
    namespace = "com.hj.average.core.network"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.gson)
    implementation(libs.gson.converter)
    implementation(libs.okhttp.logging)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlin.serialization)
}

secrets {
    defaultPropertiesFileName = "key.properties"
}
