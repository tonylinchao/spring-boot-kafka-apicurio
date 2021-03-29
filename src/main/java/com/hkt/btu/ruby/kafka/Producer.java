package com.hkt.btu.ruby.kafka;

import com.hkt.btu.ruby.kafka.schema.avro.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, Event> kafkaTemplate;

    public void send(Event payload) {
        log.info("Producer sending message {} to topic {}", payload, Topic.NAME);

        try{
            this.kafkaTemplate.send(Topic.NAME, payload);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}