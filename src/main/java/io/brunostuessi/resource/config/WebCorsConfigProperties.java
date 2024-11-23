package io.brunostuessi.resource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "web.cors")
public class WebCorsConfigProperties {

    private String[] allowedOrigins;

    private String[] allowedMethods;

    private String[] allowedHeaders;

    private String[] exposedHeaders;

    private long maxAge;


    public WebCorsConfigProperties() {
    }

    public void setAllowedOrigins(String[] allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public void setAllowedMethods(String[] allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public void setAllowedHeaders(String[] allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    public void setExposedHeaders(String[] exposedHeaders) {
        this.exposedHeaders = exposedHeaders;
    }

    public void setMaxAge(long maxAge) {
        this.maxAge = maxAge;
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