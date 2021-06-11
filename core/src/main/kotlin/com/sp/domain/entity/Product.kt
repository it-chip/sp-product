package com.sp.domain.entity

import javax.persistence.*

/**
 * @author YeonKyung Kim
 */
@Entity
@Table
data class Product(
    @Id
    val productNo: Long
)
