package com.product.catalog.ProductCatalog.app.controller;

import com.product.catalog.ProductCatalog.app.config.EnvConfig;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.logging.Logger;

public class BaseController {

    @Autowired
    private EnvConfig envConfig;

    public void setLogIdentifier(HttpServletRequest request) {

        String logIdentifier = request.getHeader(envConfig.getLogIdentifierKey());
        if (logIdentifier != null) {
            MDC.put(envConfig.getLogIdentifierKey(), logIdentifier);
        } else {
            MDC.put(envConfig.getLogIdentifierKey(), UUID.randomUUID().toString());
        }
    }
}
