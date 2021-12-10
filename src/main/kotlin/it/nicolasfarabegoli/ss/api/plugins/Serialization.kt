package it.nicolasfarabegoli.ss.api.plugins

import io.ktor.features.*
import io.ktor.application.*
import io.ktor.jackson.jackson

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        jackson()
    }
}
