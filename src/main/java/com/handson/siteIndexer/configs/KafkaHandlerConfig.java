package com.handson.siteIndexer.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.handson.siteIndexer.services.Kafka;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Return a kafka sender that represent config for each kafka producer.
 * @author Alessandro Pio Ardizio
 */
@Configuration
@Component
public class KafkaHandlerConfig {

    @Autowired
    KafkaConsumer<String,String> consumer;

    @Autowired
    KafkaProducer<String,String> producer;

    @Autowired
    ObjectMapper om;

    @Bean
    public Kafka handler(){
        return new Kafka(consumer, producer, om) ;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}