package org.javaspringcourse.actuator;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Log4j2
@Component
@Endpoint(id = "time")
public class TimeActuator {

    @ReadOperation
    public String time() {
        log.info("Current time: {}", LocalDateTime.now());
        return LocalDateTime.now().toString();
    }
}
