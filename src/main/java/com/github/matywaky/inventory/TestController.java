package com.github.matywaky.inventory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
public class TestController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/testdb")
    public String testDatabase() {
        try {
            entityManager.createNativeQuery("SELECT 1").getSingleResult();
            return "Baza danych jest widoczna!";
        } catch (Exception e) {
            return "Baza danych nie jest widoczna: " + e.getMessage();
        }
    }
}
