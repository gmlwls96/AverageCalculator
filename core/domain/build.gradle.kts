plugins {
    id("template.android.library")
}

android {
    namespace = "com.hj.average.core.domain"
}

dependencies {
    implementation(projects.core.models)
}
