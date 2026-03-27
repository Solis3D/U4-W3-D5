package Solis3D;

import Solis3D.dao.ElementoCatalogoDAO;
import Solis3D.dao.PrestitoDAO;
import Solis3D.dao.UtenteDAO;
import Solis3D.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("U4-W3-D5pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ElementoCatalogoDAO elementoCatalogoDAO = new ElementoCatalogoDAO(entityManager);
        UtenteDAO utenteDAO = new UtenteDAO(entityManager);
        PrestitoDAO prestitoDAO = new PrestitoDAO(entityManager);

        //LIBRI
        Libro libro1 = new Libro("ISBN-001", "1984", 1948, 320, "George Orwell", "distopico");
        Libro libro2 = new Libro ("ISBN-002","Fahrenheit 451", 1953, 180, "Ray Bradbury", "distopico");
        Libro libro3 = new Libro("ISBN-003", "Il Signore degli Anelli", 1954, 1200, "J.R.R. Tolkien", "Fantasy");
        /*elementoCatalogoDAO.save(libro1);
        elementoCatalogoDAO.save(libro2);
        elementoCatalogoDAO.save(libro3);*/

        //RIVISTE
        Rivista rivista1 = new Rivista("ISBN-004","EpicodeNews", 2026,80, Periodicita.SETTIMANALE);
        //elementoCatalogoDAO.save(rivista1);

        //UTENTI
        Utente utente1 = new Utente("Ugo", "Sacco", ("1998-10-30"),1);
        //utenteDAO.save(utente1);

        //PRESTITI
        Prestito prestito1 = new Prestito(utente1,libro1,LocalDate.parse("2026-03-27"));
        //prestitoDAO.save(prestito1);

        //test findByIsdn
        System.out.println("Elemento trovato per ISBN: ");
        System.out.println(elementoCatalogoDAO.findByIsbn("ISBN-001"));
        System.out.println();

        //test delete
        //elementoCatalogoDAO.deleteByIsbn("ISBN-003");

        //test findByAnnoPubblicazione
        System.out.println("Lista elementi trovati per anno pubblicazione: ");
        System.out.println(elementoCatalogoDAO.findByAnnoPubblicazione(1948));
        System.out.println();

        //test findByAutore
        System.out.println("Lista elementi trovati per autore: ");
        System.out.println(elementoCatalogoDAO.findByAutore("Ray Bradbury"));
        System.out.println();

        //test findByTitolo
        System.out.println("Lista elementi trovati per titolo: ");
        System.out.println(elementoCatalogoDAO.findByTitolo("Fahrenheit"));
        System.out.println();

    }
}
