package com.example.kafka.producer

import com.example.kafka.dto.Record
import com.example.kafka.util.JsonUtils
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * KafkaProducer
 *
 * @author JungGyun.Choi
 * @version 1.0.0
 * @since 2023. 01. 09.
 */
@RestController
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val customKafkaTemplate: KafkaTemplate<String, String>
) {

    @GetMapping("/producer")
    fun producer() {
        for (i in 1..500) {
            kafkaTemplate.send("test-kafka", "test$i")
        }
    }

    @GetMapping("/producer/key")
    fun producerKey() {
        for (i in 1..500) {
            kafkaTemplate.send("test-kafka", "Key", "test$i")
        }
    }

    @GetMapping("/producer/custom")
    fun customProducer() {
        for (i in 1..500) {
            val listRecords = listOf(Record("이름1", 1), Record("이름2", 2))
            customKafkaTemplate.send("test-kafka", "Key", JsonUtils.DEFAULT_OBJECT_MAPPER.writeValueAsString(listRecords))
        }
    }
}