
plugins {
    id("template.android.feature")
}


android {
    namespace = "com.hj.average.feature.item.list"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.kotlinx.immutable)
    
    implementation(projects.core.utils)
    implementation(projects.feature.common)
}
