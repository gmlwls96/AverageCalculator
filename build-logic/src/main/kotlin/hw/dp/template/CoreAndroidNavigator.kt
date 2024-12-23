package hw.dp.template

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureCoreAndroidNavigator() {
    with(pluginManager) {
        apply("com.google.devtools.ksp")
    }

    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("core.android.navigator.api").get())
        "implementation"(libs.findLibrary("core.android.navigator.annotation").get())
        "ksp"(libs.findLibrary("core.android.navigator.annotation").get())
        "kspAndroidTest"(libs.findLibrary("core.android.navigator.annotation").get())
        "kspTest"(libs.findLibrary("core.android.navigator.annotation").get())
    }
}
