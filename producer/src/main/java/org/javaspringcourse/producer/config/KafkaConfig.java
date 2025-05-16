package org.javaspringcourse.producer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@EnableKafka
@RequiredArgsConstructor
public class KafkaConfig {
    private final ObjectMapper objectMapper;

    @Bean
    public DefaultKafkaProducerFactoryCustomizer producerFactory() {
        return (factory) -> factory.setValueSerializer(new JsonSerializer<>(objectMapper));
    }
}
