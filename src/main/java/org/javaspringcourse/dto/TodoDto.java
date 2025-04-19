package org.javaspringcourse.dto;

import java.util.List;

public record TodoDto(String name, List<String> events) {}