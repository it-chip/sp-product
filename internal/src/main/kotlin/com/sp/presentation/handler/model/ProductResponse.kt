package com.sp.presentation.handler.model

import com.sp.domain.entity.*

/**
 * @author YeonKyung Kim
 */
data class ProductResponse(
    val productNo: Long
) {
    companion object {
        fun createBy(model: Product) = ProductResponse(
            productNo = model.productNo
        )
    }
}
