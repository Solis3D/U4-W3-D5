package Solis3D.dao;

import Solis3D.entities.ElementoCatalogo;
import Solis3D.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import javax.xml.transform.Source;
import java.lang.reflect.Type;
import java.util.List;

public class ElementoCatalogoDAO {
    private EntityManager em;

    public ElementoCatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void save (ElementoCatalogo elemento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(elemento);
        transaction.commit();

        System.out.println("Elemento " + elemento.getTitolo() + " salvato correttamente!");
    }

    public ElementoCatalogo findByIsbn (String isbn){
        TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT el FROM ElementoCatalogo el WHERE el.isbn = :isbn", ElementoCatalogo.class);
        query.setParameter("isbn", isbn);

        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("Nessun elemento trovato con il seguente ISBN: " + isbn);
            return null;
        }
    }

    public void deleteByIsbn (String isbn){
        ElementoCatalogo trovato = this.findByIsbn(isbn);

        if (trovato == null){
            System.out.println("Nessun elemento da eliminare trovato!");
            return;
        }

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(trovato);
        transaction.commit();

        System.out.println("Elemento " + trovato.getTitolo() + " con ISBN " + isbn + " eliminato!");
    }
    public List<ElementoCatalogo> findByAnnoPubblicazione(int annoPubblicazione){
        TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT el FROM ElementoCatalogo el WHERE el.annoPubblicazione = :anno", ElementoCatalogo.class);
        query.setParameter("anno", annoPubblicazione);

        return query.getResultList();
    }

    public List<Libro> findByAutore(String autore){
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<ElementoCatalogo> findByTitolo(String titolo){
        TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT el FROM ElementoCatalogo el WHERE el.titolo LIKE :titolo", ElementoCatalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }
}
