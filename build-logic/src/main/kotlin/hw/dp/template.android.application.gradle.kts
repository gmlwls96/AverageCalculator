import hw.dp.template.configureHiltAndroid
import hw.dp.template.configureKotlinAndroid

plugins {
    id("com.android.application")
    id("template.kover")
}

configureKotlinAndroid()
configureHiltAndroid()
