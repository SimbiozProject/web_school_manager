package com.example.web_school_manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {"spring.cloud.config.enabled=false"})
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
