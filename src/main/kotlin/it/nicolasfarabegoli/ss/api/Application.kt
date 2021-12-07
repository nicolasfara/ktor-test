package it.nicolasfarabegoli.ss.api

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.application.*
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.server.netty.*
import it.nicolasfarabegoli.ss.api.plugins.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    configureSecurity()
    configureSerialization()
    configureSockets()
    configureSwagger()
    configureRouting()
}
