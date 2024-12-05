plugins {
    id("template.android.library")
}

android {
    namespace = "com.hj.average.core.data"
}

dependencies {
    implementation(projects.core.network)
    implementation(projects.core.domain)
    implementation(projects.core.models)
    implementation(projects.core.datastore)
    implementation(projects.core.db)

    implementation(libs.retrofit.core)
    implementation(libs.gson)
    implementation(libs.protobuf.java.lite)
}
