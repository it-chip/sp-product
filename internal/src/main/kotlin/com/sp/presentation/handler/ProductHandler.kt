package com.sp.presentation.handler

import com.sp.application.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.server.*

/**
 * @author YeonKyung Kim
 */
@Component
class ProductHandler(
    private val productQueryService: ProductQueryService
) {

    suspend fun getProduct(request: ServerRequest): ServerResponse {
        val productNo = request.pathVariable("productNo").toLong()
        return ServerResponse.ok().bodyValueAndAwait(productQueryService.getProductByNo(productNo))
    }
}
