package com.example.kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class KafkaConsumerApplication

fun main(args: Array<String>) {
	System.setProperty("spring.config.name", "application,core")
	runApplication<KafkaConsumerApplication>(*args)
}
