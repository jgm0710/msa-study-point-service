package com.example.msastudypointservice.domain.reward

import java.util.*

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
data class InitPassorderPointCommand(
    val orderId: UUID,
    val point: Long,
    val userId: UUID
)