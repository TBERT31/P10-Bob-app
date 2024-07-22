package com.openclassrooms.bobapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class BobappApplicationTests {

	@Test
	void contextLoads() {
		// Ce test vérifie simplement que le contexte de l'application se charge correctement.
	}

	@Test
	void main() {
		// Vérifie que l'application démarre sans lancer d'exception
		assertDoesNotThrow(() -> BobappApplication.main(new String[]{}), "L'application n'a pas démarré correctement");
	}
}
