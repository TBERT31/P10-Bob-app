package com.openclassrooms.bobapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BobappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void main() {
		try {
			BobappApplication.main(new String[]{});
		} catch (Exception e) {
			throw new RuntimeException("L'application n'a pas démarré correctement", e);
		}
	}
}
