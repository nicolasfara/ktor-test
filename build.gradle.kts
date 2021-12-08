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

val stage by tasks.registering {
    dependsOn("shadowJar")
    doLast {
        val procfile = File("Procfile")
        val payload = """
            web: java -jar build/libs/ss-api-${version}-all.jar
        """.trimIndent()
        procfile.writeText(payload, Charsets.UTF_8)
    }
}

tasks {
    shadowJar {
        manifest {
            attributes(Pair("Main-Class", "it.nicolasfarabegoli.ss.api.ApplicationKt"))
        }
    }
}
