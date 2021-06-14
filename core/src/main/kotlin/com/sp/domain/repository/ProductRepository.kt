package com.sp.domain.repository

import com.sp.domain.entity.*
import org.springframework.data.jpa.repository.*

/**
 * @author YeonKyung Kim
 */
interface ProductRepository : JpaRepository<Product, Long> {
}
