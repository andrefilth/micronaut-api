package com.api.device.infra.handle.exception.notfound

import com.api.device.infra.handle.exception.ApiException


/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 16/10/2020
 */
abstract class NotFoundException : ApiException {

    protected constructor(msg: String, code: String?, shortMessage: String?) : super(
        msg,
        code!!, shortMessage!!
    )

    protected constructor(msg: String, code: String?, shortMessage: String?, data: Any?) : super(
        msg,
        code!!, shortMessage!!, data
    ) {
    }
}