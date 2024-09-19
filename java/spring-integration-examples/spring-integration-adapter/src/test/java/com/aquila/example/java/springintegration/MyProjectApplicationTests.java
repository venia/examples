package com.aquila.example.java.springintegration;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * https://docs.spring.io/spring-boot/docs/1.3.8.RELEASE/reference/html/boot-features-testing.html
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyProjectApplication.class)
@WebIntegrationTest(randomPort = true)
public class MyProjectApplicationTests {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void contextLoads() {
        String responseEntity = new TestRestTemplate().getForObject(
                "http://localhost:" + this.port + "/hello", String.class);

        Assert.assertThat(responseEntity, CoreMatchers.containsString("Hello, Spring Boot 1.3.8!"));
    }
}