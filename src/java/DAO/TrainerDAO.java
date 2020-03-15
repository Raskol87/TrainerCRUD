/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Trainer;
import java.util.List;
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
        em.close();
    }

    @Override
    public Trainer getById(int id) {
        return em.find(Trainer.class, id);
    }

    @Override
    public List<Trainer> getAll() {
        Query query = em.createNamedQuery("Trainers.findAll", Trainer.class);
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
    }

}
