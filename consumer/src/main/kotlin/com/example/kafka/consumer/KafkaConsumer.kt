package com.example.kafka.consumer

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

    @KafkaListener(topics = ["test-kafka"], containerFactory = "consumerFactory")
    fun basicConsumer(@Payload rawData: String) {
        println("=====Consumer 시작=====")
        println("Consumer1: $rawData")
        println("=====Consumer 종료=====")
    }

//    @KafkaListener(topics = ["test-kafka"], containerFactory = "consumerFactory2")
//    fun basic2Consumer(@Payload rawData: String) {
//        println("=====Consumer 시작=====")
//        println("Consumer2: $rawData")
//        println("=====Consumer 종료=====")
//    }

//    @KafkaListener(topics = ["test-kafka"], containerFactory = "customConsumerFactory", concurrency = "3")
//    fun customConsumer(@Payload rawData: String) {
//        val result = JsonUtils.DEFAULT_OBJECT_MAPPER.readValue(rawData, Record::class.java)
//        println("Name: ${result.name}")
//        println("age: ${result.age}")
//    }

}