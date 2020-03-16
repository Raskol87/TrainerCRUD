/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Trainer;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author kyrik
 */
public class TrainerDAO implements DAOInt<Trainer> {

    EntityManager em = Persistence.createEntityManagerFactory(
            "TrainerCRUDAssignmentPU").createEntityManager();

    public static final String ID = "idTrainer";
    public static final String FNAME = "firstName";
    public static final String LNAME = "lastName";
    public static final String SUBJECT = "subject";
    public static final String TAG = "tag";

    @Override
    public void create(Trainer tr) {
        em.getTransaction().begin();
        em.persist(tr);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Trainer tr) {
        em.getTransaction().begin();
        em.remove(em.find(Trainer.class, tr.getIdTrainer()));
        em.getTransaction().commit();
    }

    @Override
    public Trainer getById(int id) {
        return em.find(Trainer.class, id);
    }

    @Override
    public List<Trainer> getAll() {
        Query query = em.createNamedQuery("Trainer.findAll", Trainer.class);
        return query.getResultList();

    }

    @Override
    public void update(Trainer tr) {
        
        Trainer persistedTr = em.find(Trainer.class, tr.getIdTrainer());
        em.getTransaction().begin();
        persistedTr.setFirstName(tr.getFirstName());
        persistedTr.setLastName(tr.getLastName());
        persistedTr.setSubject(tr.getSubject());
        persistedTr.setTag(tr.getTag());
        em.getTransaction().commit();
                
    }

    @Override
    public List<Trainer> getQueryResult(Map attr) {
        String[] args = new String[attr.size()];

        int i = 0;
        for (Object a : attr.keySet()) {
            args[i] = (String) a;
            i++;
        }
        String jpql = buildQuery(args);
        Query query = em.createQuery(jpql, Trainer.class);
        // Query query = em.createQuery("SELECT t FROM Trainer t WHERE t.firstName = 'KYRIAKOS' and t.lastName = 'KYRIAKIDIS'", Trainer.class);
        for (String a : args) {
            System.out.println(a + "   " + attr.get(a));
            query.setParameter(a, attr.get(a));
        }

        return query.getResultList();
    }

    private String buildQuery(String[] args) {
        StringBuilder query = new StringBuilder(
                "SELECT t FROM Trainer t WHERE t.");
        query = query.append(args[0]).append(" = :").append(args[0]);
        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                query = query.append(" and t.").append(args[i]).append(" = :").
                        append(args[i]);
            }
        }

        return query.toString();
    }

}
