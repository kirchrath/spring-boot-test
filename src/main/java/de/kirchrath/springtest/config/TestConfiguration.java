package de.kirchrath.springtest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("de.kirchrath.springtest")
public class TestConfiguration {
    private String foo;
    private String dir;
}
