package com.sp.domain.entity

import com.sp.domain.*
import com.sp.domain.enums.*
import org.hibernate.annotations.*
import java.time.*
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @author YeonKyung Kim
 */
@Entity
@Table(name="product_item") // 네이밍..
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no")
    val productNo: Long,

    @Column(name = "product_name")
    val productName: String,

    @Column(name = "price")
    val price: Long?,

    @Type(type = GenericEnumType.NAME)
    @Column(name = "status_type")
    val statusType: ProductStatusType,

    @Column(name = "register_ymdt")
    val registerDateTime: LocalDateTime = LocalDateTime.now(),

    @Column(name = "update_ymdt")
    val updateDateTime: LocalDateTime?
)
