package com.tesco.web.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(
        classes = {WebTestApplication.class},
        webEnvironment = DEFINED_PORT,
        properties = {"server.port=8090"})
@AutoConfigureWebMvc
@AutoConfigureWebTestClient
@AutoConfigureWireMock(port = 8989, stubs = "classpath:/mappings")
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class WebTestIT {
        @Autowired
        private WebTestClient webClient;

        @Test
        void test() {
                webClient.get()
                        .uri("http://localhost:8989/fruits/apple")
                        .exchange()
                        .expectBody()
                        .jsonPath("id")
                        .isEqualTo("721fdf98-41b3-4b5d-b0f3-b5e633aa08a0");


                webClient.get()
                        .uri("http://localhost:8989/fruits/lol")
                        .exchange()
                        .expectStatus()
                        .isEqualTo(404);
        }
}
