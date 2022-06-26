package com.example.msastudypointservice.adepter.`in`.eventhandler

import com.example.msastudypointservice.adepter.`in`.eventhandler.event.OrderCreatedEvent
import com.example.msastudypointservice.application.point.IncreaseRewardAplService
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/21
 * */
@Service
class OrderCreatedEventHandler(val increaseRewardAplService: IncreaseRewardAplService) {

    val logger = LoggerFactory.getLogger(this::class.java)


    @KafkaListener(topics = ["com.example.orderservice.domain.order.Order"])
    fun onMessage(kafkaMessage : String) {
        val orderCreatedEvent = OrderCreatedEvent.ofJson(kafkaMessage)

        val increaseByOrder = increaseRewardAplService.increaseByOrder(orderCreatedEvent.toIncreaseRewardCommand())

        logger.info("increase by order success. created history id : [{}]", increaseByOrder.toString())
    }
}