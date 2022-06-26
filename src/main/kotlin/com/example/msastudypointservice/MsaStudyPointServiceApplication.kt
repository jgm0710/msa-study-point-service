package com.example.msastudypointservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
class MsaStudyPointServiceApplication

fun main(args: Array<String>) {
    runApplication<MsaStudyPointServiceApplication>(*args)
}
