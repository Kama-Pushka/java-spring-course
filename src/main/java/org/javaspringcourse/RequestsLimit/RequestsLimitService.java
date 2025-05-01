package org.javaspringcourse.RequestsLimit;

import lombok.RequiredArgsConstructor;
import org.javaspringcourse.props.RequestsLimitProps;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RequestsLimitService {
    private final RequestsLimitProps requestsLimitProps;
    private final Map<String, Integer> requestsCount = new HashMap<>();

    public boolean canHandleRequest(String apiName) {
        if (requestsCount.containsKey(apiName)) {
            requestsCount.put(apiName, requestsCount.get(apiName) + 1);
        } else {
            requestsCount.put(apiName, 1);
        }
        return requestsCount.get(apiName) <= requestsLimitProps.getMax();
    }
}
