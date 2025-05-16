package org.javaspringcourse.consumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.javaspringcourse.consumer.dto.MessageDto;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.CommonLoggingErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
@RequiredArgsConstructor
public class KafkaConfig {
    public static final String CONSUMER_LISTENER_CONTAINER_FACTORY = "consumerListenerContainerFactory";

    private final KafkaProperties kafkaProperties;
    private final ObjectMapper objectMapper;

    @Bean(CONSUMER_LISTENER_CONTAINER_FACTORY)
    public ConcurrentKafkaListenerContainerFactory<String, MessageDto> consumerListenerContainerFactory() {
        return buildListenerContainerFactory(MessageDto.class);
    }

    <T> ConcurrentKafkaListenerContainerFactory<String, T> buildListenerContainerFactory(Class<T> clazz) {
        var consumerFactory = new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(),
                new StringDeserializer(),
                new ErrorHandlingDeserializer<>(
                        new JsonDeserializer<>(
                                clazz, objectMapper, false
                        )
                )
        );

        var listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<String, T>();
        listenerContainerFactory.setConsumerFactory(consumerFactory);
        listenerContainerFactory.setCommonErrorHandler(commonLoggingErrorHandler());
        return listenerContainerFactory;
    }

    @Bean
    public CommonLoggingErrorHandler commonLoggingErrorHandler() { // только логирование ошибки
        return new CommonLoggingErrorHandler();
    }
}
