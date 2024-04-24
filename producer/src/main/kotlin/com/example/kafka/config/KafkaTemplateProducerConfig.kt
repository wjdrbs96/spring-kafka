package com.example.kafka.config

import com.fasterxml.jackson.databind.JsonSerializer
import java.io.Serializable
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

/**
 * KafkaTemplateConfig
 *
 * @author JungGyun.Choi
 * @version 1.0.0
 * @since 2023. 01. 09.
 */
@Configuration
class KafkaTemplateProducerConfig(
    private val kafkaProperty: KafkaProperty
) {

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        val producerFactory: ProducerFactory<String, String> = DefaultKafkaProducerFactory(producerStringConfig())
        return KafkaTemplate(producerFactory)
    }

    @Bean
    fun customKafkaTemplate(): KafkaTemplate<String, Serializable> {
        val producerFactory: ProducerFactory<String, Serializable> = DefaultKafkaProducerFactory(producerJsonConfig())
        return KafkaTemplate(producerFactory)
    }

    fun producerStringConfig(): Map<String, Serializable> =
        mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperty.endpoint,
            ProducerConfig.ACKS_CONFIG to "all",
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
        )

    fun producerJsonConfig(): Map<String, Serializable> =
        mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperty.endpoint,
            ProducerConfig.ACKS_CONFIG to "all",
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java
        )
}