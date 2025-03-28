package com.stringboot.BaoVeRung.dao;

import com.stringboot.BaoVeRung.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class UserDAOImp implements UserDAO {
    private EntityManager em;
    @Autowired
    public UserDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> findAll() {
    TypedQuery<User> query = em.createQuery("from User ", User.class);
    return query.getResultList();
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User save(User user) {
        User saved = em.merge(user);
        return saved;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
 User user = em.find(User.class, id);
 em.remove(user);
    }
}
