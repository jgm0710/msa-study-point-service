package com.example.msastudypointservice.application.point.command

import com.example.msastudypointservice.domain.reward.CreateIncreasePointHistoryCommand
import com.example.msastudypointservice.domain.reward.InitPassorderPointCommand
import java.util.*

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
class IncreaseRewardCommand(
    val orderId: UUID,
    val point: Long,
    val userId: UUID
) {
    fun toInitFirstHistoryCommand(): InitPassorderPointCommand {
        return InitPassorderPointCommand(
            orderId = orderId,
            point = point,
            userId = userId
        )
    }

    fun toIncreasePointHistoryCommand(): CreateIncreasePointHistoryCommand {
        return CreateIncreasePointHistoryCommand(
            orderId = orderId,
            point = point
        )
    }
}