# URIBuilder-Java

![](https://github.com/BastiaanJansen/URIBuilder-Java/workflows/Build/badge.svg)
![](https://github.com/BastiaanJansen/URIBuilder-Java/workflows/Test/badge.svg)
![](https://img.shields.io/github/license/BastiaanJansen/URIBuilder-Java)
![](https://img.shields.io/github/issues/BastiaanJansen/URIBuilder-Java)

A utility Java library to easily create and parse URI's.

## Installation

### Maven
```xml
<dependency>
    <groupId>com.github.bastiaanjansen</groupId>
    <artifactId>uribuilder-java</artifactId>
    <version>1.0.1</version>
</dependency>
```

### Gradle
```gradle
implementation 'com.github.bastiaanjansen:uribuilder-java:1.0.1'
```

## Usage

To create a URI:
```java
URI uri = new URIBuilder()
    .withScheme("https")
    .withAuthority("authority.com")
    .withPath("/path")
    .withQueryParamater("key", "value")
    .withFragment("fragment")
    .build()
```

To parse a URI string to a URI instance:
```java
URI uri = URIBuilder.parse("https://authority.com/path?key=value#fragment");
```
