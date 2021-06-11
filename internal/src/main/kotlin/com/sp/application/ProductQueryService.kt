package com.sp.application

import com.sp.domain.entity.*
import com.sp.domain.repository.*
import kotlinx.coroutines.*
import org.springframework.data.repository.*
import org.springframework.stereotype.*

/**
 * @author YeonKyung Kim
 */
@Service
class ProductQueryService(
    private val productRepository: ProductRepository
) {

    suspend fun getProductByNo(productNo: Long): Product {
        return productRepository.findByIdOrNull(productNo) ?: throw Exception()
    }

    suspend fun getProduct(): List<Product> {
        return productRepository.findAll()
    }
}
