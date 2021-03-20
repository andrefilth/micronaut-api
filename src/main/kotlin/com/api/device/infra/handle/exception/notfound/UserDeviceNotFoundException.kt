package com.api.device.infra.handle.exception.notfound

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 20/10/2020
 */
class UserDeviceNotFoundException : NotFoundException {
    constructor(msg: String) : super(msg, ORIGIN_NOT_FOUND, msg)

    constructor(msg: String, code: String?, shortMessage: String?, data: Any?) : super(
        msg,
        code,
        shortMessage,
        data
    ) {
    }

    companion object {
        private const val ORIGIN_NOT_FOUND = "user_device_not_found"
    }
}