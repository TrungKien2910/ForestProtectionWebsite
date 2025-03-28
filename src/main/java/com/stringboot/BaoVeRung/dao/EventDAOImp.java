package com.stringboot.BaoVeRung.dao;

import com.stringboot.BaoVeRung.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class EventDAOImp implements EventDAO {
    private EntityManager em;
    @Autowired
    public EventDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Event> findAll() {
    TypedQuery<Event> query = em.createQuery("from Event", Event.class);
    return query.getResultList();
    }

    @Override
    public Event findById(int id) {
        return em.find(Event.class, id);
    }

    @Override
    public Event save(Event event) {
        Event saved = em.merge(event);
        return saved;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
 Event event = em.find(Event.class, id);
 em.remove(event);
    }
}
