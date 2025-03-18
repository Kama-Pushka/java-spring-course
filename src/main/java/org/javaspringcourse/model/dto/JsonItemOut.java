package org.javaspringcourse.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class JsonItemOut {
    private double price;
    private Info info;

    @Data
    @Builder
    public static class Info {
        int id;
        Date date;
    }
}
