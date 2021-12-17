package com.bastiaanjansen.url;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class URLBuilder {

    private String scheme;
    private String authority;
    private String path;
    private Map<String, String> query;
    private String fragment;

    public URLBuilder() { }

    public URLBuilder withScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    public URLBuilder withQueryParameter(String key, String value) {
        query.put(key, value);
        return this;
    }

    public URLBuilder withAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    public URLBuilder withPath(String path) {
        this.path = path;
        return this;
    }

    public URLBuilder withFragment(String fragment) {
        this.fragment = fragment;
        return this;
    }

    public URI build() throws URISyntaxException {
        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<String, String> queryParameter: query.entrySet()) {
            queryString
                    .append(queryParameter.getKey())
                    .append("=")
                    .append(queryParameter.getValue());
        }

        return new URI(scheme, authority, path, queryString.toString(), fragment);
    }

}
