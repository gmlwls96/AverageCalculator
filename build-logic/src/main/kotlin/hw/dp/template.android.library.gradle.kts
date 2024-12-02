import gradle.kotlin.dsl.accessors._8f6c2245db7331d07c38be67b73b6260.android
import hw.dp.template.configureCoroutineAndroid
import hw.dp.template.configureHiltAndroid
import hw.dp.template.configureKotlinAndroid

plugins {
    id("com.android.library")
    id("template.verify.detekt")
    id("template.kover")
    id("template.tasks")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

configureKotlinAndroid()
configureCoroutineAndroid()
configureHiltAndroid()

dependencies {
    //testImplementation(project(":core:test"))
}
