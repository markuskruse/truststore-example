package com.nicecorp.truststoretest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Config {

    @Value("${badssl.truststore.file}")
    private String truststoreFile;

    @Value("${badssl.truststore.password}")
    private String truststorePassword;

    @PostConstruct
    public void configureSSL() {
        System.setProperty("javax.net.ssl.trustStore", truststoreFile);
        System.setProperty("javax.net.ssl.trustStorePassword", truststorePassword);
    }


}
