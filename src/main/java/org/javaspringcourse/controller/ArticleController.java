package org.javaspringcourse.controller;

import lombok.RequiredArgsConstructor;
import org.javaspringcourse.dto.ArticleIn;
import org.javaspringcourse.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody ArticleIn article) {
        return service.create(article);
    }
}
