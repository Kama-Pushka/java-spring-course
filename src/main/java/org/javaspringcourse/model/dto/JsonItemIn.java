package org.javaspringcourse.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class JsonItemIn {
    private double price;
    private Info info;

    @Data
    public static class Info {
        Date date;
    }
}
