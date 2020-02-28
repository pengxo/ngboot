package com.pengxo.kafka;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping(value = "/publishkafka")
    public ResponseEntity<String> sendMessageToKafkaTopic(@ApiParam(name = "message", value = "message for testing with kafka.", required = true) @RequestParam final String message) {
        kafkaService.sendMessage(message);
        return new ResponseEntity<>("Hello from Kafka with angular 2", HttpStatus.OK);
    }

}
