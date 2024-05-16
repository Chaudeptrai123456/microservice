package com.example.serverUser.Service.Kafka;

import com.example.serverUser.DTO.KafkaEvent.InventoryEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {
    Logger log = LoggerFactory.getLogger(KafkaProducerService.class);
    @Value("${spring.kafka.product.topic}")
    public String topic;
    @Autowired
    KafkaTemplate<Integer, InventoryEvent> kafkaTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);


    public CompletableFuture<SendResult<Integer, InventoryEvent>> sendInventoryEvent_Async(InventoryEvent inventoryEvent) throws JsonProcessingException {

        var key = inventoryEvent.getInventoryId();

        CompletableFuture<SendResult<Integer, InventoryEvent>> completableFuture = kafkaTemplate.send(topic, key, inventoryEvent);

        return completableFuture.whenComplete(((sendResult, throwable) -> {
            if (throwable != null) {
                handleFailure(key, inventoryEvent, throwable);
            } else {
                handleSuccess(key, inventoryEvent, sendResult);
            }
        }));
    }
    private void handleSuccess(Integer key, Object value, SendResult<Integer, InventoryEvent> sendResult) {
        log.info("Message sent successfully for the key: {} and the value: {}, partition is: {}",
                key, value, sendResult.getRecordMetadata().partition());
    }

    private void handleFailure(Integer key, Object value, Throwable throwable) {
        log.error("Error sending message and exception is {}", throwable.getMessage(), throwable);
    }

}
