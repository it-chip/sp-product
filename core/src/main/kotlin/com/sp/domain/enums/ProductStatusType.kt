package com.sp.domain.enums

/**
 * @author YeonKyung Kim
 */
enum class ProductStatusType(
    override val value: String,
    val label: String
) : GenericEnum {
    PREPARING("PSTP0001", "준비중"),
    USED("PSTP0002", "사용중"),
    STOP("PSTP0003", "사용중지");

}
