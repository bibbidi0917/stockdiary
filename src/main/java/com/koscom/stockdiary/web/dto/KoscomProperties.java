package com.koscom.stockdiary.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "koscom.stock")
public class KoscomProperties {
    private String url;
    private String apikey;
}