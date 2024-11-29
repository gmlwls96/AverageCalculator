import hw.dp.template.configureVerifyDetekt

configureVerifyDetekt()

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    jvmTarget = JavaVersion.VERSION_18.majorVersion

    buildUponDefaultConfig = true
    allRules = false
    parallel = true
    config.setFrom(listOf(file("$rootDir/config/detekt/detekt.yml")))

    ignoreFailures = false

    reports {
        file("$rootDir/build/reports/test/${project.name}/").mkdirs()
        html.required.set(true) // observe findings in your browser with structure and code snippets
        html.outputLocation.set(file("$rootDir/build/reports/detekt/${project.name}.html"))
        xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
        xml.outputLocation.set(file("$rootDir/build/reports/detekt/${project.name}.xml"))
    }
}