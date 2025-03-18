package org.javaspringcourse.service;

import org.javaspringcourse.model.JsonItem;
import org.javaspringcourse.model.dto.JsonItemIn;
import org.javaspringcourse.model.dto.JsonItemOut;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonService {
    private final static List<JsonItem> jsonItems = new ArrayList<>();

    public JsonItemOut register(JsonItemIn jsonItem) {
        var json = JsonItem.builder()
                .id(jsonItems.size() + 1)
                .price(jsonItem.getPrice())
                .date(jsonItem.getInfo().getDate())
                .build();
        jsonItems.add(json);
        return toJsonItemOut(json);
    }

    private JsonItemOut toJsonItemOut(JsonItem jsonItem) {
        var info = JsonItemOut.Info.builder()
                .id(jsonItem.getId())
                .date(jsonItem.getDate())
                .build();
        return JsonItemOut.builder()
                .price(jsonItem.getPrice())
                .info(info)
                .build();
    }
}
