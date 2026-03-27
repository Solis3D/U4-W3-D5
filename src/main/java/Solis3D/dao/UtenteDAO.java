package Solis3D.dao;

import Solis3D.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.UUID;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em){
        this.em = em;
    }

    public void save(Utente utente){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();

        System.out.println("L'utente " + utente.getNome() + " " + utente.getCognome() + " è stato salvato correttamente!");
    }

    public Utente findById(UUID id) {
        Utente trovato = this.em.find(Utente.class, id);
        if (trovato == null) throw new NoResultException("Nessun risultato trovato con l'id fornito");
        return trovato;
    }

    public void deleteById(UUID id) {
        Utente trovato = this.findById(id);

        if (trovato == null) {
            System.out.println("Utente non trovato");
            return;
        }

        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        this.em.remove(trovato);
        transaction.commit();

        System.out.println("Utente " + trovato.getNome() + " " + trovato.getCognome() + " eliminato con successo!");
    }
}
