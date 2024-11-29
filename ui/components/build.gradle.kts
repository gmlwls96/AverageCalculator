
plugins {
    id("template.android.library")
    id("template.android.compose")
}

android{
    namespace = "com.hj.average.ui.component"
}

dependencies {
    implementation(projects.core.res)
    implementation(projects.ui.theme)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.compose.material)
}