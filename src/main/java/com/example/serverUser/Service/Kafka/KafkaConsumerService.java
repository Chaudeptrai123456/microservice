package com.example.serverUser.Service.Kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Log
public class KafkaConsumerService {

    @Autowired
    ObjectMapper objectMapper;

    public void processLibraryEvent() {

    }

}
