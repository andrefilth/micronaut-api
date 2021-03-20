package com.api.device.infra.handle.exception

import com.api.device.infra.handle.exception.response.ErrorResponse

abstract class ApiException : RuntimeException {

    private val code: String


    private var shortMessage: String


    private var data: Any? = null

    protected constructor(msg: String, code: String, shortMessage: String) : super(msg) {
        this.code = code
        this.shortMessage = shortMessage
    }

    protected constructor(msg: String, code: String, shortMessage: String, data: Any?) : super(msg) {
        this.code = code
        this.shortMessage = shortMessage
        this.data = data
    }

    val errorModel: ErrorResponse
        get() = ErrorResponse(code = code, message = message, shortMessage = shortMessage, data = data)

}