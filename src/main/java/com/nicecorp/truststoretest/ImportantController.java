package com.nicecorp.truststoretest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@Slf4j
public class ImportantController {

    @RequestMapping("/important")
    public BusinessObject checkFunction() throws Exception {
        log.info("Starting very important requeast (like vip)");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://self-signed.badssl.com/"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("Done with request, got status: {}", response.statusCode());
            log.info("Got response: {}", response.body());
            if (response.statusCode() < 399) {
                return new BusinessObject("It worked");
            } else {
                return new BusinessObject("It didn't work: ");
            }
        } catch (Exception e) {
            log.error("The request didn't work", e);
            return new BusinessObject("It didn't work: ");
        }
    }

}
