package com.api.device.infra.handle

import com.api.device.infra.handle.exception.notfound.NotFoundException
import com.api.device.infra.handle.extractor.FiedToErroRespondeExtractor
import io.micronaut.http.HttpStatus.BAD_REQUEST
import io.micronaut.http.HttpStatus.NOT_FOUND
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Status
import javax.inject.Inject
import javax.validation.ConstraintViolationException

open class ControllerAdviceExceptionHandler {

    @Inject
    lateinit var fiedToErroRespondeExtractor: FiedToErroRespondeExtractor

    @Error(exception = ConstraintViolationException::class)
    @Status(BAD_REQUEST)
    open fun handler(exception: ConstraintViolationException) = fiedToErroRespondeExtractor.extract(exception)

    @Error(exception = NotFoundException::class)
    @Status(NOT_FOUND)
    open fun handler(exception: NotFoundException) = exception.errorModel

}