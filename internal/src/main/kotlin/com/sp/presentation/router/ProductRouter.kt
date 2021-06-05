package com.sp.presentation.router

import com.sp.presentation.handler.*
import org.springframework.context.annotation.*
import org.springframework.http.*
import org.springframework.web.reactive.function.server.*

/**
 * @author YeonKyung Kim
 */
@Configuration
class ProductRouter(
    private val productHandler: ProductHandler
) {

    @Bean
    fun routeProduct(): RouterFunction<ServerResponse> {
        return coRouter {
            (accept(MediaType.APPLICATION_JSON) and "/internal/product").nest {
                GET("/{productNo}", productHandler::getProduct)
            }
        }
    }
}
