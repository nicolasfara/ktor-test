package it.nicolasfarabegoli.ss.api.plugins

import com.papsign.ktor.openapigen.annotations.Response
import com.papsign.ktor.openapigen.openAPIGen
import com.papsign.ktor.openapigen.route.apiRouting
import com.papsign.ktor.openapigen.route.path.normal.get
import com.papsign.ktor.openapigen.route.path.normal.post
import com.papsign.ktor.openapigen.route.response.respond
import com.papsign.ktor.openapigen.route.route
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*

fun Application.configureRouting() {

    @Response("A String Response")
    data class StringResponse(val str: String)

    apiRouting {
        route("some").get<Unit, StringResponse> {
            respond(StringResponse("Hello world"))
        }
        route("bar").post<Unit, StringResponse, Unit> { _, _ ->
            respond(StringResponse("wo"))
        }
    }

    routing {
        get("/openapi.json") {
            call.respond(application.openAPIGen.api.serialize())
        }

        get("/") {
            call.respondRedirect("/swagger-ui/index.html?url=/openapi.json", true)
        }
    }
}
