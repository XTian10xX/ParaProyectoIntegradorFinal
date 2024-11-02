package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        // Crear un nueva persona
        Persona persona = new Persona("Juan","Zapata",
        "juan@gmail.com");        
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();

        // Buscar persona
        Persona foundUser = em.find(Persona.class, persona.getId());
        System.out.println("Usuario encontrado: " + foundUser.getNombre());

        em.close();
        emf.close();
    }
}