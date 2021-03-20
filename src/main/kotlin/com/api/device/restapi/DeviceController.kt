package com.api.device.restapi

import com.api.device.domain.devices.DeviceRequest
import com.api.device.infra.handle.ControllerAdviceExceptionHandler
import com.api.device.infra.handle.exception.notfound.UserDeviceNotFoundException
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/v1")
open class DeviceController: ControllerAdviceExceptionHandler() {
    private val log: Logger = LoggerFactory.getLogger(DeviceController::class.java)


    @Post("/devices")
    open fun insertDevices(@Valid request: DeviceRequest){
        log.info("Dados recebidos: $request")
    }
    @Get("/devices/device/{id}")
    open fun findtDevices(@PathVariable(name = "id") id : String){
        log.info("consultar id: $id")
        throw UserDeviceNotFoundException("Device $id não encontrado")
    }

}