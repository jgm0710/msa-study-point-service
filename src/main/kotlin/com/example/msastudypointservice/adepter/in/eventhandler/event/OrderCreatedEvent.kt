package com.example.msastudypointservice.adepter.`in`.eventhandler.event

import com.example.msastudypointservice.application.point.command.IncreaseRewardCommand
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.*

data class OrderCreatedEvent(
    var orderId : String,
    var ordererId: String,
    var usedRewards: List<Reward>,
    var status: String,
    var createdAt: String
) {
    fun toIncreaseRewardCommand(): IncreaseRewardCommand {
        val value = usedRewards.first().value
        return IncreaseRewardCommand(
            orderId = UUID.fromString(orderId),
            point = value.toLong(),
            userId = UUID.fromString(ordererId),
        )
    }

    data class Reward(
        var rewardKind: RewardKind,
        var value: Int
    )

    enum class RewardKind {
        PASSORDER_POINT,
        STORE_POINT,
        STORE_STAMP;
    }

    companion object {
        fun ofJson(json: String): OrderCreatedEvent {
            val objectMapper = ObjectMapper()

            val map = objectMapper.readValue(json, Map::class.java)
            val rewardsMap = map["usedRewards"] as List<*>

            val rewards = rewardsMap.map {
                it as LinkedHashMap<*, *>
                Reward(
                    rewardKind = RewardKind.valueOf(it["rewardKind"] as String),
                    value = it["value"] as Int
                )
            }

            return OrderCreatedEvent(
                orderId = map["orderId"] as String,
                ordererId = map["ordererId"] as String,
                usedRewards = rewards,
                status = map["status"] as String,
                createdAt = map["createdAt"] as String,
            )
        }
    }

}