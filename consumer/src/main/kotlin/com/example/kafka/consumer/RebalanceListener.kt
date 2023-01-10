package com.example.kafka.consumer

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener
import org.apache.kafka.common.TopicPartition
import org.springframework.stereotype.Component

/**
 * RebalanceListener
 *
 * @author JungGyun.Choi
 * @version 1.0.0
 * @since 2023. 01. 11.
 */
@Component
class RebalanceListener : ConsumerRebalanceListener {
    override fun onPartitionsRevoked(partitions: MutableCollection<TopicPartition>?) {
        println("Partition are assigned")
    }

    override fun onPartitionsAssigned(partitions: MutableCollection<TopicPartition>?) {
        println("Partitions are revoked")
    }
}