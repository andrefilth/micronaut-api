package com.api.device.infra.handle

import com.api.device.infra.handle.exception.ErrorResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Status
import java.util.stream.Collectors
import javax.validation.ConstraintViolationException


open class ControllerAdviceExceptionHandler {

    @Error(exception = ConstraintViolationException::class)
    @Status(HttpStatus.BAD_REQUEST)
    open fun handler(ex: ConstraintViolationException): ErrorResponse? {

        val violations = ex.constraintViolations
        ex.localizedMessage
        val map = violations
            .stream()
            .map {
                ErrorResponse(
                    message = it.messageTemplate,
                    code = "CONSTRAINT_VIOLATION",
                    shortMessage = "constraint violation error",
                    field = it.propertyPath.toString()
                )
            }
            .collect(Collectors.toSet())
        return ErrorResponse(message = "Erro de validação de dados do formulário",
            code = HttpStatus.BAD_REQUEST.name,
            shortMessage = "constraint violation error",
            errors = map
        )
    }
}