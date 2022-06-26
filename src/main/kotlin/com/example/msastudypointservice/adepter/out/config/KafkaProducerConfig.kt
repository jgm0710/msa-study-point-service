package com.example.msastudypointservice.adepter.out.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

/**
 *
 *
 * @author gm-jeong
 * @since 2022/06/21
 * */
@Configuration
class KafkaProducerConfig {

    private val BROKER_CONNECTION = "127.0.0.1:9092"

    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val configurationProperties =  HashMap<String, Any>()
        configurationProperties[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = BROKER_CONNECTION
        configurationProperties[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.qualifiedName?:""
        configurationProperties[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.qualifiedName?:""
        return  DefaultKafkaProducerFactory(configurationProperties)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }
}