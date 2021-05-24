package com.example.springboothelloworld

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest
class SpringBootHelloWorldApplicationTests {

    @Test
    fun contextLoads() {
    }

}

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldIntegrationTests(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `Greeting with success`() {
        val entity = restTemplate.getForEntity<String>("/hello-world/david")

        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(entity.body).isEqualTo("Hello, david")
    }
}
