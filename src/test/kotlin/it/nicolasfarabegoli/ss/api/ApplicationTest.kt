package it.nicolasfarabegoli.ss.api

import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*
import it.nicolasfarabegoli.ss.api.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({
            configureSwagger()
            configureSerialization()
            configureRouting()
        }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.MovedPermanently, response.status())
            }
        }
    }
}