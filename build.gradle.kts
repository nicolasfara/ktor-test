@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    application
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.shadow)
}

group = "it.nicolasfarabegoli.ss.api"
version = "0.0.1"
application {
    mainClass.set("it.nicolasfarabegoli.ss.api.ApplicationKt")
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation(libs.bundles.ktor)
    implementation(libs.openapi)
    implementation(libs.logback)
    testImplementation(libs.kotlinTest)
    testImplementation(libs.ktorTest)
}

tasks {
    shadowJar {
        manifest {
            attributes(Pair("Main-Class", "it.nicolasfarabegoli.ss.api.ApplicationKt"))
        }
    }
}
