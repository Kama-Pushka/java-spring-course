package org.javaspringcourse.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class JsonItem {
    private int id;
    private double price;
    private Date date;
}
