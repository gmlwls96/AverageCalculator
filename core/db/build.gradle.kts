plugins {
    id("template.android.library")
}

android {
    namespace = "com.hj.average.core.db"
}

dependencies {
    implementation(libs.gson)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    annotationProcessor(libs.room.compiler)
    ksp(libs.room.compiler)
}
