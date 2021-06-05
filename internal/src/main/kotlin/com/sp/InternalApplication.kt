package com.sp

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.boot.context.properties.*

/**
 * @author YeonKyung Kim
 */
@SpringBootApplication
@ConfigurationPropertiesScan
class InternalApplication

fun main(args: Array<String>) {
    runApplication<InternalApplication>(*args)
}
