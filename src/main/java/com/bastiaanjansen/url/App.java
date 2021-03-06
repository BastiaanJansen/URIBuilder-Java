package com.bastiaanjansen.url;

import java.net.URI;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URLBuilder().build();
    }
}
