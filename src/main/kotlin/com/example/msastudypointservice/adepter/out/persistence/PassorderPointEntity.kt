package com.example.msastudypointservice.adepter.out.persistence

import com.example.msastudypointservice.domain.reward.PassorderPoint
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
@Entity
class PassorderPointEntity(
    @Id
    val id: UUID,
    val userId: UUID,
    val orderId: UUID,
    val totalPoint: Long,
    val pointHistory: Long,
    val createdAt: Instant
){
    companion object {
        fun PassorderPoint.toEntity(): PassorderPointEntity {
            return PassorderPointEntity(
                id = id,
                userId = userId,
                orderId = orderId,
                totalPoint = totalPoint,
                pointHistory = pointHistory,
                createdAt = createdAt
            )
        }
    }

    fun toDomain() : PassorderPoint{
        return PassorderPoint(
            id = id,
            userId = userId,
            orderId = orderId,
            totalPoint = totalPoint,
            pointHistory = pointHistory,
            createdAt = createdAt
        )
    }
}