package org.javaspringcourse.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javaspringcourse.config.property.MinecraftServerStartProp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Log4j2
@Configuration
@EnableConfigurationProperties(MinecraftServerStartProp.class)
@RequiredArgsConstructor
public class MinecraftServerStartConfig {
    private final MinecraftServerStartProp minecraftServerStartProp;

    @Bean
    @Profile("test")
    public String testServerChecker() {
        log.info("Running testServerChecker...");
        return "testServerChecker";
    }

    @Bean
    @ConditionalOnBean(name = "testServerChecker")
    public String testServerProfiler() {
        log.info("Running testServerProfiler...");
        return "testServerChecker";
    }

    @Bean
    @ConditionalOnExpression("'${server.env-var}' != 'default'")
    public String specialServerMode() {
        log.info("Running specialServerMode...");
        log.warn("GEORGE DROID ©NEGROTECH 2077 joined the server.");
        return "specialServerMode";
    }

    @PostConstruct
    public void init() {
        log.info("Server Name: {}", minecraftServerStartProp.getName());
        log.info("Server Params: {}", minecraftServerStartProp.getStartParams());
    }
}
