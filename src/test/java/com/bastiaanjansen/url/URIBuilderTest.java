package com.bastiaanjansen.url;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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
    void parseScheme() {
        URIBuilder builder = URIBuilder.parse(url);
        String expected = "https";

        assertThat(builder.getScheme(), is(expected));
    }

    @Test
    void parseAuthority() {
        URIBuilder builder = URIBuilder.parse(url);
        String expected = "authority.com";

        assertThat(builder.getAuthority(), is(expected));
    }

    @Test
    void parsePath() {
        URIBuilder builder = URIBuilder.parse(url);
        String expected = "/path";

        assertThat(builder.getPath(), is(expected));
    }

    @Test
    void parseFragment() {
        URIBuilder builder = URIBuilder.parse(url);
        String expected = "fragment";

        assertThat(builder.getFragment(), is(expected));
    }

    @Test
    void parseQuery() {
        URIBuilder builder = URIBuilder.parse(url);
        Map<String, String> query = new HashMap<>();
        query.put("key", "value");

        assertThat(builder.getQuery(), is(query));
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

    @Test
    void build_doesNotThrow() throws URISyntaxException {
        assertDoesNotThrow(() -> {
            new URIBuilder()
                .withScheme("https")
                .withAuthority("authority.com")
                .withPath("/path")
                .withQueryParameter("key", "value")
                .withFragment("fragment")
                .build();
        });
    }

    @Test
    void buildToString() throws URISyntaxException {
        URI uri = new URIBuilder()
            .withScheme("https")
            .withAuthority("authority.com")
            .withPath("/path")
            .withQueryParameter("key", "value")
            .withFragment("fragment")
            .build();

        assertThat(uri.toString(), is(url));
    }
}