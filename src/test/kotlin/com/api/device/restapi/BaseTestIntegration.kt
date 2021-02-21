package com.api.device.restapi

import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.restassured.RestAssured.baseURI
import org.junit.jupiter.api.BeforeEach


@MicronautTest
open class BaseTestIntegration(private val server: EmbeddedServer) {

    @BeforeEach
    open fun setUp() {
        baseURI = "http://localhost:${server.port}/api/v1"

    }
}