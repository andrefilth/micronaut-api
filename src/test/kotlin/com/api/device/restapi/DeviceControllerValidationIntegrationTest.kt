package com.api.device.restapi

import com.api.device.domain.devices.DeviceRequest
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.hasItem
import org.junit.jupiter.api.Test
import javax.inject.Inject
import javax.validation.Validator

@MicronautTest
internal class DeviceControllerValidationIntegrationTest(server: EmbeddedServer) : BaseTestIntegration(server) {

    @Inject
    lateinit var validator: Validator

    @Test
    fun `dado um request, se o user_id vier vazio, então estourar erro`() {
        val request = DeviceRequest(userId = "", installationId = "12345", deviceId = "112233")
        val constraintViolations = validator.validate(request)
        assertThat(constraintViolations.size).isEqualTo(1)


    }
    @Test
    fun `dado um request, se o user_id e installation_id vierem vazios, então estourar erro`() {
        val request = DeviceRequest(userId = "", installationId = "", deviceId = "112233")
        val constraintViolations = validator.validate(request)
        assertThat(constraintViolations.size).isEqualTo(2)

    }

    @Test
    fun `dado uma chamada da api, se o user_id vier vazio, então erro de validação`() {

        Given {
            contentType(ContentType.JSON)
            body((DeviceRequest(userId = "", installationId = "12345", deviceId = "112233")))
            log().all()
        } When {
            log().all()
            post("/devices")
        } Then {
            log().all()
            statusCode(400)
            body("message", `is`("Erro de validação de dados do formulário"))
            body("code", `is`("BAD_REQUEST"))
            body("short_message", `is`("constraint violation error"))
            body("errors.message", hasItem("O user_id é um campo obrigatório"))
            body("errors.code", hasItem("CONSTRAINT_VIOLATION"))
            body("errors.field", hasItem("insertDevices.request.userId"))

        }

    }
    @Test
    fun `dado uma chamada da api, se o user_id e installation_id vierem vazios, então erro de validação`() {

        Given {
            contentType(ContentType.JSON)
            body((DeviceRequest(userId = "", installationId = " ", deviceId = "112233")))
            log().all()
        } When {
            log().all()
            post("/devices")
        } Then {
            log().all()
            statusCode(400)
            body("message", `is`("Erro de validação de dados do formulário"))
            body("code", `is`("BAD_REQUEST"))
            body("short_message", `is`("constraint violation error"))

            body("errors.message", hasItem("O user_id é um campo obrigatório"))
            body("errors.code", hasItem("CONSTRAINT_VIOLATION"))
            body("errors.field", hasItem("insertDevices.request.userId"))

            body("errors.message", hasItem("O installation_id é um campo obrigatório"))
            body("errors.code", hasItem("CONSTRAINT_VIOLATION"))
            body("errors.field", hasItem("insertDevices.request.installationId"))

        }
    }
}