
import gradle.kotlin.dsl.accessors._8f6c2245db7331d07c38be67b73b6260.android
import gradle.kotlin.dsl.accessors._8f6c2245db7331d07c38be67b73b6260.implementation
import hw.dp.template.configureHiltAndroid
import hw.dp.template.configureCoreAndroidNavigator
import hw.dp.template.libs

plugins {
    id("template.android.library")
    id("template.android.compose")
    id("template.kover")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }
}

configureHiltAndroid()

configureCoreAndroidNavigator()

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:models"))
    implementation(project(":core:res"))
    implementation(project(":ui:components"))
    implementation(project(":ui:theme"))
    implementation(project(":ui:route"))
    val libs = project.extensions.libs

    implementation(libs.findLibrary("androidx.appcompat").get())
    implementation(libs.findLibrary("androidx.activity").get())
    implementation(libs.findLibrary("androidx.fragment").get())
    implementation(libs.findLibrary("lifecycle.viewmodel.ktx").get())
    implementation(libs.findLibrary("constraintlayout").get())
    implementation(libs.findLibrary("material").get())

    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("androidx.compose.navigation").get())
    androidTestImplementation(libs.findLibrary("androidx.compose.navigation.test").get())

    implementation(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())
    implementation(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
}
