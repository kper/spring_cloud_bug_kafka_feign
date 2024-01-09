package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AcceptanceKafkaTestProducer {

    private static final Logger LOG = LoggerFactory.getLogger(AcceptanceKafkaTestProducer.class);

    @Autowired
    private StreamBridge bridge;

    class Sensor {
        private String data;
    }

    public void sendAcceptanceResponse() {
        // We have to set all fields
        var sensor = new Sensor();
        sensor.data = "foo";
        bridge.send("acceptanceOutput123", sensor);
    }

}
