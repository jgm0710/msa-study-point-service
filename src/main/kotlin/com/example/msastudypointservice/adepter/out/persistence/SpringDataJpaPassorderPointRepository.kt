package com.example.msastudypointservice.adepter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
interface SpringDataJpaPassorderPointRepository : JpaRepository<PassorderPointEntity, UUID> {

    fun findFirstByUserIdOrderByCreatedAtDesc(userId : UUID) : PassorderPointEntity?
}