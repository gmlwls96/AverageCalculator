plugins {
    id("template.android.library")
}

android {
    namespace = "com.hj.average.core.test"
}

dependencies {
    api(libs.junit4)
    api(libs.junit.vintage.engine)
    api(libs.kotlin.test)
    api(libs.mockk)
    api(libs.turbine)
    api(libs.coroutines.test)
    api(libs.androidx.test.ext)
}
