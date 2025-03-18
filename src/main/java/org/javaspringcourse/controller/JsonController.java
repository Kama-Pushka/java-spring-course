package org.javaspringcourse.controller;

import lombok.RequiredArgsConstructor;
import org.javaspringcourse.exception.BadGatewayException;
import org.javaspringcourse.model.dto.JsonItemIn;
import org.javaspringcourse.model.dto.JsonItemOut;
import org.javaspringcourse.service.JsonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/json")
public class JsonController {
    private final JsonService service;

    @PostMapping
    public JsonItemOut registerJson(@RequestBody JsonItemIn product) {
        return service.register(product);
    }

    @GetMapping("/error502")
    public void getError502() {
        throw new BadGatewayException("502 Bad Gateway");
    }
}
