package com.example.msastudypointservice.adepter.out.eventpublisher

import com.example.msastudypointservice.domain.reward.PassorderPointIncreaseEventPublisher
import com.example.msastudypointservice.domain.reward.PassorderPointIncreasedEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
@Service
class KafkaPassorderPointIncreaseEventPublisher(
    val kafkaTemplate: KafkaTemplate<String, String>
) : PassorderPointIncreaseEventPublisher {

    val logger = LoggerFactory.getLogger(this::class.java)

    override fun publish(aggregateType: String, events: Iterable<PassorderPointIncreasedEvent>) {
        val objectMapper = ObjectMapper()
        events.forEach {
            val eventJson = objectMapper.writeValueAsString(it)
            logger.info("Passorder point increase event publish. event json : [{}]", eventJson)
            kafkaTemplate.send(aggregateType, eventJson)
        }
    }
}