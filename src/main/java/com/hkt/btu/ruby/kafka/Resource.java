package com.hkt.btu.ruby.kafka;

import com.hkt.btu.ruby.kafka.schema.avro.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/kafka")
public class Resource {

    private final Producer producer;

    @PostMapping(value = "/publish")
    public void publish(@RequestBody Event event) {
        log.info("REST Controller has received entity: {}", event);
        this.producer.send(event);
    }

    @GetMapping(value = "/batch")
    public void batch() {
        Event event = new Event();
        for(int i=0; i<5000; i++){
            event.setName("Tony");
            event.setDescription("Perf test [" + i +"]");
            event.setCreatedOn((int) System.currentTimeMillis());
            this.producer.send(event);
        }
    }
}