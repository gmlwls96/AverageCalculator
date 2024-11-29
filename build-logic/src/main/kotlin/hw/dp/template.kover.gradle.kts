import gradle.kotlin.dsl.accessors._5ac7912a8f9b21663d15b5aac980482f.koverReport

plugins {
    id("org.jetbrains.kotlinx.kover")
}

koverReport {
    val excludedFiles = listOf(
        "*.BuildConfig",
        "*.MainActivity",
        "*Fragment",
        "*Fragment\$*",
        "*Activity",
        "*Activity\$*",
        "*.databinding.*",
        "*.theme.*",
        "*.di.*",
        "*.Hilt_*",
        "*.*_HiltModules*",
        "*.*_HiltComponents*",
        "*.CBankApplication",
        "dagger.*",
        "*.*_Factory",
        "*.*_ComponentTreeDeps",
        "*.*ViewModelFactory*",
        "hilt*",
        "*.screen.*",
        "*.screen",
        "*.RetrofitFactoryImpl",
        "*.ui.component.*",
        "*.assertion.*",
        "*.interceptor.*",
        "*.api.*",
        "*.ComposableSingletons*",
        "*.MainActivityKt",
        "*.datastore.*",
        "*.db.*"
    )

    filters {
        excludes {
            classes(excludedFiles)
        }
    }

    defaults {
        mergeWith("debug")
        html {
            title = "Test report "
            onCheck = true
            setReportDir(layout.buildDirectory.dir("$buildDir/reports/kover/html"))
        }

        verify {
            onCheck = true
            rule {
                isEnabled = true

                bound {
                    minValue = 70
                    maxValue = 100
                    metric = kotlinx.kover.gradle.plugin.dsl.MetricType.LINE
                    aggregation = kotlinx.kover.gradle.plugin.dsl.AggregationType.COVERED_PERCENTAGE
                }
            }
        }
    }
}

