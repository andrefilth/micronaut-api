package com.api.device.restapi

import com.api.device.domain.devices.DeviceRequest
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Controller(value = "/api/v1")
open class DeviceController {
    private val log: Logger = LoggerFactory.getLogger(DeviceController::class.java)

    @Post("/devices")
    open fun insertDevices(@Valid request: DeviceRequest){
        log.info("Dados recebidos: $request")
    }
}