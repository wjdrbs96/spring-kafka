package com.example.kafka.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 *
 * @author JungGyun.Choi
 * @version 1.0.0
 * @since 2023. 01. 10.
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "kafka")
data class KafkaProperty(
    val endpoint: String,
)