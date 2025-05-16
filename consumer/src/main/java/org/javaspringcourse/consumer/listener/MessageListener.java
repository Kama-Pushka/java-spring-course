package org.javaspringcourse.consumer.listener;

import lombok.extern.log4j.Log4j2;
import org.javaspringcourse.consumer.config.KafkaConfig;
import org.javaspringcourse.consumer.dto.MessageDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MessageListener {

    @KafkaListener(
            containerFactory = KafkaConfig.CONSUMER_LISTENER_CONTAINER_FACTORY,
            topics = "${javaspringcourse.kafka.message.topic}",
            groupId = "${javaspringcourse.kafka.message.groupId}"
    )
    public void receiveMessage(@Payload MessageDto message) {
        log.info("Received message: {}", message.message());
    }
}
