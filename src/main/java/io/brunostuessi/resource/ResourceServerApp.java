package io.brunostuessi.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ResourceServerApp {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceServerApp.class);


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ResourceServerApp.class, args);
    }


    @Bean
    ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(ServerProperties serverProperties) {
        return (evt) -> {
            if ("true".equalsIgnoreCase(System.getProperty("dev.test.oom"))) {
                LOG.warn("Provoke OOM");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                final List<byte[]> waste = new ArrayList<>();
                while (waste.size() < Integer.MAX_VALUE) {
                    waste.add(new byte[1024 * 1024]);
                }
            }
         };
    }

}
