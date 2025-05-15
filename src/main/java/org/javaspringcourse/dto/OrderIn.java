package org.javaspringcourse.dto;

import org.javaspringcourse.model.Chocolate;

public record OrderIn(Chocolate chocolate, int count) {
}
