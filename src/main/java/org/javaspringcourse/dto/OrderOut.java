package org.javaspringcourse.dto;

import org.javaspringcourse.model.Chocolate;

public record OrderOut(int orderId, Chocolate chocolate, int count) {
}
