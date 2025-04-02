package org.javaspringcourse.service;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.javaspringcourse.dto.ArticleIn;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
public class ArticleService {
    public String create(@Valid ArticleIn article) {
        var ans = "Creating a new article: " + article.toString();
        log.info(ans);
        return ans;
    }
}
