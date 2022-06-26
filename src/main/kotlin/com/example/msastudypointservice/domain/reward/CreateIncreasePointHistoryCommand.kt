package com.example.msastudypointservice.domain.reward

import java.util.*

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
class CreateIncreasePointHistoryCommand(
    val point: Long,
    val orderId: UUID
)