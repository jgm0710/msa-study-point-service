package com.example.msastudypointservice.domain.reward

import com.example.orderservice.common.ResultWithDomainEvents
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import java.time.Instant
import java.util.UUID

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/21
 * */
class PassorderPoint(
    val id: UUID,
    val userId: UUID,
    val orderId: UUID,
    val totalPoint: Long,
    val pointHistory: Long,
    val createdAt: Instant
) {
    fun createIncreasePointHistory(createIncreasePointHistoryCommand: CreateIncreasePointHistoryCommand): ResultWithDomainEvents<PassorderPoint, PassorderPointIncreasedEvent> {
        val newPoint = PassorderPoint(
            id = UUID.randomUUID(),
            userId  = userId,
            orderId = createIncreasePointHistoryCommand.orderId,
            totalPoint = totalPoint + createIncreasePointHistoryCommand.point,
            pointHistory = createIncreasePointHistoryCommand.point,
            createdAt = Instant.now()
        )

        val event = PassorderPointIncreasedEvent(
            id = newPoint.id.toString(),
            orderId = newPoint.orderId.toString(),
            totalPoint = newPoint.totalPoint,
            pointHistory = newPoint.pointHistory,
            createdAt = newPoint.createdAt.toString()
        )

        return ResultWithDomainEvents(newPoint, listOf(event))
    }

    companion object {
        fun initFirstHistory(initPassorderPointCommand: InitPassorderPointCommand): ResultWithDomainEvents<PassorderPoint, PassorderPointIncreasedEvent> {
            val passorderPoint = PassorderPoint(
                id = UUID.randomUUID(),
                userId  = initPassorderPointCommand.userId,
                orderId = initPassorderPointCommand.orderId,
                totalPoint = initPassorderPointCommand.point,
                pointHistory = initPassorderPointCommand.point,
                createdAt = Instant.now(),
            )

            val event = PassorderPointIncreasedEvent(
                id = passorderPoint.id.toString(),
                orderId = passorderPoint.orderId.toString(),
                totalPoint = passorderPoint.totalPoint,
                pointHistory = passorderPoint.pointHistory,
                createdAt = passorderPoint.createdAt.toString()
            )

            return ResultWithDomainEvents(passorderPoint, listOf(event))
        }
    }
}