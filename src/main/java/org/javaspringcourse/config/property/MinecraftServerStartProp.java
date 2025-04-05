package org.javaspringcourse.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "server.start")
public class MinecraftServerStartProp {
    String name;
    List<String> startParams;
}
