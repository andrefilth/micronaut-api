package com.api.device.domain.devices

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@JsonInclude(JsonInclude.Include.NON_NULL)
@Introspected
data class DeviceRequest(

    @JsonProperty("user_id")  @field:NotBlank(message = "O user_id é um campo obrigatório") val userId: String,
    @JsonProperty("device_id")  @field:NotBlank val deviceId: String,
    @JsonProperty("installation_id")  @field:NotBlank val installationId: String,
) {

}
