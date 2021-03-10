package com.bastiaanjansen.url;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class URIBuilderTest {

    private String url;

    @BeforeEach
    void setUp() {
        this.url = "https://authority.com/path?key=value#fragment";
    }

    @AfterEach
    void tearDown() {
        this.url = null;
    }

    @Test
    void parse() {
        URIBuilder builder = URIBuilder.parse(url);

        assertEquals(builder.getScheme(), "https");
        assertEquals(builder.getAuthority(), "authority.com");
        assertEquals(builder.getPath(), "/path");
        assertEquals(builder.getFragment(), "fragment");

        Map<String, String> query = new HashMap<>();
        query.put("key", "value");

        assertEquals(builder.getQuery(), query);

    }

    @Test
    void build() {
        URIBuilder builder = new URIBuilder();
            builder
                    .withScheme("https")
                    .withAuthority("authority.com")
                    .withPath("/path")
                    .withQueryParameter("key", "value")
                    .withFragment("fragment");

            assertDoesNotThrow(() -> {
                URI uri = builder.build();
            assertEquals(uri.toString(), url);
        });
    }
}