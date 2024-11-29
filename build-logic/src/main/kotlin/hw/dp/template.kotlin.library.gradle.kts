import hw.dp.template.configureKotlin

plugins {
    kotlin("jvm")
    id("template.verify.detekt")
    id("template.kover")
}

configureKotlin()
