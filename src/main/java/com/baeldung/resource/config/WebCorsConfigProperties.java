package com.baeldung.resource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "web.cors")
public class WebCorsConfigProperties {

    private final String[] allowedOrigins;

    private final String[] allowedMethods;

    private final String[] allowedHeaders;

    private final String[] exposedHeaders;

    private final long maxAge;


    public WebCorsConfigProperties(String[] allowedOrigins, String[] allowedMethods, long maxAge,
                                   String[] allowedHeaders, String[] exposedHeaders) {
        this.allowedOrigins = allowedOrigins;
        this.allowedMethods = allowedMethods;
        this.maxAge = maxAge;
        this.allowedHeaders = allowedHeaders;
        this.exposedHeaders = exposedHeaders;
    }

    public String[] getAllowedOrigins() {
        return allowedOrigins;
    }

    public String[] getAllowedMethods() {
        return allowedMethods;
    }

    public long getMaxAge() {
        return maxAge;
    }

    public String[] getAllowedHeaders() {
        return allowedHeaders;
    }

    public String[] getExposedHeaders() {
        return exposedHeaders;
    }

}