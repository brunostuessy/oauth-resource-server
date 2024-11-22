package com.baeldung.resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.baeldung.resource.ResourceServerApp;

@SpringBootTest(classes = { ResourceServerApp.class })
public class ContextIntegrationTest {

    @Test
    public void whenLoadApplication_thenSuccess() {
        // pass
    }

}