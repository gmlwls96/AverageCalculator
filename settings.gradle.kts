@file:Suppress("UnstableApiUsage")

import java.util.Properties

pluginManagement {
    repositories {
        includeBuild("build-logic")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

val gradleProperties = Properties()
gradleProperties.load(file("github.properties").inputStream())

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/hl-fintech/Core-android")
            credentials {
                username = System.getenv("github_username") ?: gradleProperties.getProperty("github_username")
                password = System.getenv("github_access_token") ?: gradleProperties.getProperty("github_access_token")
            }
        }
    }
}

rootProject.name = "AverageCalculator"
include(
    ":app",
    ":core:data",
    ":core:datastore",
    ":core:domain",
    ":core:models",
    ":core:network",
    ":core:test",
    ":core:res",

    ":feature:common",
    ":feature:main",
    ":feature:itemlist",
    ":feature:setting",

    ":ui:components",
    ":ui:route",
    ":ui:theme",
)
 