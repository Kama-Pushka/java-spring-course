package org.javaspringcourse.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javaspringcourse.producer.dto.MessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessageService {
    @Value("${javaspringcourse.kafka.message.topic}")
    private String messageTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(MessageDto message) {
        kafkaTemplate.send(messageTopic, message);
    }
}
