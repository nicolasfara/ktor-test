package it.nicolasfarabegoli.ss.api.plugins

import com.papsign.ktor.openapigen.OpenAPIGen
import com.papsign.ktor.openapigen.schema.namer.DefaultSchemaNamer
import com.papsign.ktor.openapigen.schema.namer.SchemaNamer
import io.ktor.application.*
import kotlin.reflect.KType

fun Application.configureSwagger() {
    install(OpenAPIGen) {
        info {
            version = "0.1.0"
            title = "Smart IoT Shelf"
            description = "TODO"
            contact {
                name = "Nicolas Farabegoli"
                email = "nicolas.farabegoli@gmail.com"
            }
        }
        server("http://localhost:8080/") {
            description = "TODO"
        }
        //rename DTOs from java type name to generator compatible form
        replaceModule(DefaultSchemaNamer, object : SchemaNamer {
            val regex = Regex("[A-Za-z0-9_.]+")

            override fun get(type: KType): String {
                return type.toString().replace(regex) { it.value.split(".").last() }.replace(Regex(">|<|, "), "_")
            }
        })
    }
}