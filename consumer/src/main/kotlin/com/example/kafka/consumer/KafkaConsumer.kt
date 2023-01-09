package com.example.kafka.consumer

import com.example.kafka.dto.Record
import com.example.kafka.util.JsonUtils
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

/**
 * KafkaConsumer
 *
 * @author JungGyun.Choi
 * @version 1.0.0
 * @since 2023. 01. 10.
 */
@Component
class KafkaConsumer {

    @KafkaListener(topics = ["gyun"], containerFactory = "consumerFactory", concurrency = "3")
    fun basicConsumer(@Payload rawData: String) {
        println("Consumer: $rawData")
    }

    @KafkaListener(topics = ["gyun"], containerFactory = "customConsumerFactory", concurrency = "3")
    fun customConsumer(@Payload rawData: String) {
        val result = JsonUtils.DEFAULT_OBJECT_MAPPER.readValue(rawData, Record::class.java)
        println("Name: ${result.name}")
        println("age: ${result.age}")
    }

}