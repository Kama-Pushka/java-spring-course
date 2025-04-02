package org.javaspringcourse.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.javaspringcourse.validation.RussianFullName;
import org.javaspringcourse.validation.Title;

@Data
public class ArticleIn {
    @Title private String title;
    @RussianFullName private String author;
    @NotBlank private String content;

    @Override
    public String toString() {
        return title + " (" + author + ")";
    }
}
