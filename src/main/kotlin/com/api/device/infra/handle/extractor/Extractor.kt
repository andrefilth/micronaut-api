package com.api.device.infra.handle.extractor

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 20/03/2021
 */
@FunctionalInterface
interface Extractor<T, D> {
    fun extract(extract: T): D
}