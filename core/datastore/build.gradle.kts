import com.google.protobuf.gradle.id

plugins {
    id("template.android.library")
    id("kotlinx-serialization")
    id("com.google.protobuf")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }

    generateProtoTasks {
        all()
            .forEach{ task->
            task.builtins {
                id("java") {
                    option("lite")
                }
            }
        }
    }
}

android {
    namespace = "com.hj.average.core.datastore"
}

dependencies {
    implementation(projects.core.models)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.immutable)

    implementation(libs.data.store)
    implementation(libs.data.store.core)
    implementation(libs.protobuf.java.lite)
}
