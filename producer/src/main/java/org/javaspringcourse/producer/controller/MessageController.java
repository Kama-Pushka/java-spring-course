package org.javaspringcourse.producer.controller;

import lombok.RequiredArgsConstructor;
import org.javaspringcourse.producer.dto.MessageDto;
import org.javaspringcourse.producer.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody MessageDto message) {
        messageService.sendMessage(message);
    }
}
