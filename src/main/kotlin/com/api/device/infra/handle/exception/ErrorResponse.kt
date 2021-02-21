package com.api.device.infra.handle.exception

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonProperty


@JsonPropertyOrder("message", "code", "field", "data", "short_message", "errors")
@JsonInclude(value = NON_NULL)
data class ErrorResponse(
    @JsonProperty("short_message")
    val shortMessage: String? = null,
    val message: String =  "Ops! Ocorreu um erro inesperado.",
    val code: String? = null,
    val field: String? = null,
    val data: Any? = null,
    val errors: Set<ErrorResponse>? = null

) {
}