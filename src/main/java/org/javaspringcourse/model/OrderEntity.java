package org.javaspringcourse.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderEntity {
    private int orderId;
    private Chocolate chocolateType;
    private int count;
}
