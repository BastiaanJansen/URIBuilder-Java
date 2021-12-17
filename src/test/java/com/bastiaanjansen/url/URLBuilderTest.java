package com.bastiaanjansen.url;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

class URLBuilderTest {

    @Test
    void constructor_instanceOfURLBuilder() {
        URLBuilder builder = new URLBuilder();

        assertThat(builder, instanceOf(URLBuilder.class));
    }

}