package com.api.device.infra.handle.extractor

import com.api.device.infra.handle.exception.response.ErrorResponse
import io.micronaut.http.HttpStatus
import java.util.stream.Collectors
import javax.inject.Singleton
import javax.validation.ConstraintViolationException


@Singleton
class FiedToErroRespondeExtractor: Extractor<ConstraintViolationException, ErrorResponse> {
    override fun extract(exception: ConstraintViolationException): ErrorResponse {
        return ErrorResponse(message = "Erro de validação de dados do formulário",
                code = HttpStatus.BAD_REQUEST.name,
                shortMessage = "constraint violation error",
                errors = exception.constraintViolations
                        .stream()
                        .map {
                            ErrorResponse(
                                    message = it.messageTemplate,
                                    code = "CONSTRAINT_VIOLATION",
                                    shortMessage = "constraint violation error",
                                    field = it.propertyPath.toString()) }.collect(Collectors.toSet())
        )
    }
}