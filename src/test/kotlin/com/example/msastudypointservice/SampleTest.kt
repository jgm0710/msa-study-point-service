package com.example.msastudypointservice

import com.example.msastudypointservice.adepter.`in`.eventhandler.event.OrderCreatedEvent
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/26
 * */
class SampleTest {

    @Test
    fun test() {
        val st = """
             {"orderId":"65c145f6-0f0e-4105-9b48-801b2d1a2b93","ordererId":"7382b1d8-1f71-4021-8c1c-e4fea2f0aa0b","usedRewards":[{"value":10,"rewardKind":"PASSORDER_POINT"}],"status":"CREATED_PENDING","createdAt":"2022-06-26T09:08:27.833141Z"}
        """.trimIndent()

        val objectMapper = ObjectMapper()

        val readValue = objectMapper.readValue(st, Map::class.java)

        println("readValue[\"orderId\"] = ${readValue["orderId"]}")


        println("readValue = ${readValue}")
    }
}