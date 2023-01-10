package com.example.kafka.config

import java.io.Serializable
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

/**
 * KafkaTemplateConsumerConfig
 *
 * @author JungGyun.Choi
 * @version 1.0.0
 * @since 2023. 01. 09.
 */
@Configuration
class KafkaTemplateConsumerConfig(
    private val kafkaProperty: KafkaProperty
) {

    @Bean
    fun consumerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.consumerFactory = DefaultKafkaConsumerFactory(consumerConfig())
        return factory
    }

    @Bean
    fun <T> customConsumerFactory(): ConcurrentKafkaListenerContainerFactory<String, Class<T>> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Class<T>>()
        factory.consumerFactory = DefaultKafkaConsumerFactory(consumerConfig())
        return factory
    }

    fun consumerConfig(): Map<String, Serializable> =
        mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperty.endpoint,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.GROUP_ID_CONFIG to "test",
            ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG to 3000,
            ConsumerConfig.MAX_POLL_RECORDS_CONFIG to 1,
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest",
            ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG to "false"
        )
}