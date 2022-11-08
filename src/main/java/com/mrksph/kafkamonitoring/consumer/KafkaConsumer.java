package com.mrksph.kafkamonitoring.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    @Value("${kafka.groupId}")
    private String groupId;

    @KafkaListener(topics = "${kafka.topicName}", groupId = "${kafka.groupId}")
    public void listen(String message) {
        log.info("Received message in group '{}': {}", groupId, message);
    }
}
