package it.nicolasfarabegoli.ss.api.plugins

import com.papsign.ktor.openapigen.openAPIGen
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
        get("/openapi.yaml") {
            call.respond(application.openAPIGen.api.serialize())
        }

        get("/") {
            call.respondText("Hello World!")
        }

        get("/docs") {
            call.respondRedirect("/swagger-ui/index.html?url=/openapi.yaml", true)
        }
    }
}
