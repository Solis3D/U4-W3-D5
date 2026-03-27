package Solis3D.dao;

import Solis3D.entities.ElementoCatalogo;
import Solis3D.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class PrestitoDAO {

    private final EntityManager em;

    public PrestitoDAO(EntityManager em){
        this.em = em;
    }

    public void save(Prestito prestito){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();

        System.out.println("Il prestito con ID: " + prestito.getId() + " è stato salvato correttamente!");
    }

    public Prestito findById(UUID id) {
        Prestito trovato = this.em.find(Prestito.class, id);
        if (trovato == null) throw new NoResultException("Nessun risultato trovato con l'id fornito");
        return trovato;
    }

    public void deleteById(UUID id) {
        Prestito trovato = this.findById(id);

        if (trovato == null) {
            System.out.println("Prestito non trovato");
            return;
        }

        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        this.em.remove(trovato);
        transaction.commit();

        System.out.println("Prestito con ID: " + trovato.getId() + " eliminato con successo!");
    }
}
