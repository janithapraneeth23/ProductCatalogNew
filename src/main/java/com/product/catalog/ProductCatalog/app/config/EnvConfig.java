package com.product.catalog.ProductCatalog.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "msce")

public class EnvConfig {
    public String getLogIdentifierKey() {
        return logIdentifierKey;
    }

    public void setLogIdentifierKey(String logIdentifierKey) {
        this.logIdentifierKey = logIdentifierKey;
    }

    @Value("${log.identifierKey}")
    private String logIdentifierKey;
}
