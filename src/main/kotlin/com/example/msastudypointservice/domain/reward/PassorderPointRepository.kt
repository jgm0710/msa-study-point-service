package com.example.msastudypointservice.domain.reward

import java.util.UUID

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
interface PassorderPointRepository {
    fun save(passorderPoint: PassorderPoint ) : PassorderPoint

    fun findByIdOrNull(passorderPointId: UUID): PassorderPoint?
    fun findLastPointHistory(userId: UUID) : PassorderPoint?
}