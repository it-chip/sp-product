package com.sp.presentation.handler

import com.sp.application.*
import com.sp.presentation.handler.model.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.server.*

/**
 * @author YeonKyung Kim
 */
@Component
class ProductHandler(
    private val productQueryService: ProductQueryService
) {

    suspend fun getProducts(request: ServerRequest): ServerResponse {
        val productNo = request.pathVariable("productNo").toLong()
        return ServerResponse.ok().bodyValueAndAwait(ProductResponse.createBy(productQueryService.getProductByNo(productNo)))
    }

    suspend fun getProduct(request: ServerRequest): ServerResponse {
        return ServerResponse.ok().bodyValueAndAwait(productQueryService.getProduct())
    }
}
