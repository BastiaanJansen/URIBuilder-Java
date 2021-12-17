package com.bastiaanjansen.url;

import java.net.URI;
import java.net.URISyntaxException;

public class ExampleApp {
    public static void main(String[] args) throws URISyntaxException {
        URIBuilder builder = URIBuilder.parse("https://google.com:8080");
        System.out.println(builder.build().toString());

        URI uri = new URIBuilder()
                .withScheme("https")
                .withAuthority("google.com")
                .withFragment("fragment")
                .withQueryParameter("key", "value")
                .withQueryParameter("key2", "value2")
                .build();

        System.out.println(uri.toString());
    }
}
