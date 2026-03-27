package Solis3D;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("U4-W3-D5pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("Hello World!")
        ;
    }
}
