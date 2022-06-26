package com.example.msastudypointservice.application.point

import com.example.msastudypointservice.application.point.command.IncreaseRewardCommand
import com.example.msastudypointservice.domain.reward.PassorderPoint
import com.example.msastudypointservice.domain.reward.PassorderPointIncreaseEventPublisher
import com.example.msastudypointservice.domain.reward.PassorderPointIncreasedEvent
import com.example.msastudypointservice.domain.reward.PassorderPointRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
@Service
class IncreaseRewardAplService(val pointRepository: PassorderPointRepository, val passorderPointIncreaseEventPublisher: PassorderPointIncreaseEventPublisher) {

    @Transactional
    fun increaseByOrder(increaseRewardCommand: IncreaseRewardCommand): UUID {
        val passorderPoint = pointRepository.findLastPointHistory(increaseRewardCommand.userId)
        return if (passorderPoint != null) {
            createIncreasePointHistory(passorderPoint, increaseRewardCommand)
        } else {
            initFirstPointHistory(increaseRewardCommand)
        }

    }

    private fun initFirstPointHistory(increaseRewardCommand: IncreaseRewardCommand): UUID {
        val resultWithDomainEvents = PassorderPoint.initFirstHistory(increaseRewardCommand.toInitFirstHistoryCommand())

        val savedId = pointRepository.save(resultWithDomainEvents.domain).id

        passorderPointIncreaseEventPublisher.publish(
            PassorderPointIncreasedEvent::class.qualifiedName ?: "",
            resultWithDomainEvents.events
        )
        return savedId
    }

    private fun createIncreasePointHistory(
        passorderPoint: PassorderPoint,
        increaseRewardCommand: IncreaseRewardCommand
    ): UUID {
        val resultWithDomainEvents =
            passorderPoint.createIncreasePointHistory(increaseRewardCommand.toIncreasePointHistoryCommand())

        val savedId = pointRepository.save(resultWithDomainEvents.domain).id

        passorderPointIncreaseEventPublisher.publish(
            PassorderPointIncreasedEvent::class.qualifiedName ?: "",
            resultWithDomainEvents.events
        )

        return savedId
    }

}