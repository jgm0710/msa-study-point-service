package com.example.msastudypointservice.domain.reward

import com.example.orderservice.common.DomainEvent
import java.time.Instant
import java.util.*

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
data class PassorderPointIncreasedEvent(
    val id: String,
    val orderId: String,
    val totalPoint: Long,
    val pointHistory: Long,
    val createdAt: String
) : DomainEvent