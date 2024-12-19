
plugins {
    id("template.android.feature")
}


android {
    namespace = "com.hj.average.feature.main"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.kotlinx.immutable)
    implementation(projects.core.datastore)
    implementation(projects.ui.route)
    implementation(projects.feature.itemlist)
    implementation(projects.feature.setting)
    implementation(projects.feature.detail)
    implementation(projects.feature.add)
}
