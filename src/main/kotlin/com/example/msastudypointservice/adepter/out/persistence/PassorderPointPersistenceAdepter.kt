package com.example.msastudypointservice.adepter.out.persistence

import com.example.msastudypointservice.adepter.out.persistence.PassorderPointEntity.Companion.toEntity
import com.example.msastudypointservice.domain.reward.PassorderPoint
import com.example.msastudypointservice.domain.reward.PassorderPointRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.*

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
@Repository
class PassorderPointPersistenceAdepter(
    val springDataJpaPassorderPointRepository: SpringDataJpaPassorderPointRepository
) : PassorderPointRepository {
    override fun save(passorderPoint: PassorderPoint): PassorderPoint {
        return springDataJpaPassorderPointRepository.save(passorderPoint.toEntity()).toDomain()
    }

    override fun findByIdOrNull(passorderPointId: UUID): PassorderPoint? {
        return springDataJpaPassorderPointRepository.findByIdOrNull(passorderPointId)?.toDomain()
    }

    override fun findLastPointHistory(userId: UUID): PassorderPoint? {
        return springDataJpaPassorderPointRepository.findFirstByUserIdOrderByCreatedAtDesc(userId)?.toDomain()
    }
}