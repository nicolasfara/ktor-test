package it.nicolasfarabegoli.ss.api.plugins

import com.papsign.ktor.openapigen.OpenAPIGen
import io.ktor.application.*
import io.ktor.application.*

fun Application.configureSwagger() {
    install(OpenAPIGen) {
        serveSwaggerUi = true
        swaggerUiPath = "/swagger-ui"
    }
}