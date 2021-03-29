package com.hkt.btu.ruby.kafka;

import com.hkt.btu.ruby.kafka.schema.avro.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Consumer {

    @KafkaListener(topics = Topic.NAME, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Event message) {
        log.info("Consumer consumed message {} from topic {}", message, Topic.NAME);
    }
}
