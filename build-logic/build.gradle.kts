plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.verify.detektPlugin)
    implementation(libs.kover.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "template.android.hilt"
            implementationClass = "hw.dp.template.HiltAndroidPlugin"
        }
        register("kotlinHilt") {
            id = "template.kotlin.hilt"
            implementationClass = "hw.dp.template.HiltKotlinPlugin"
        }
    }
}