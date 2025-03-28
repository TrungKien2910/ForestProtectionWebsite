package com.stringboot.BaoVeRung.dao;

import com.stringboot.BaoVeRung.dto.BlogDTO;
import com.stringboot.BaoVeRung.dto.ScheduleDTO;
import com.stringboot.BaoVeRung.entity.Blog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class BlogDAOImp implements BlogDAO {
    private EntityManager em;
    @Autowired
    public BlogDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<BlogDTO> findAll() {
        TypedQuery<BlogDTO> query = em.createQuery(
                "SELECT new com.stringboot.BaoVeRung.dto.BlogDTO(b.blogId, u.username, b.title, b.content, b.createdAt) " +
                        "FROM Blog b JOIN b.user u",
                BlogDTO.class
        );
        return query.getResultList();
    }


    @Override
    public BlogDTO findById(int id) {
        TypedQuery<BlogDTO> query = em.createQuery(
                "SELECT new com.stringboot.BaoVeRung.dto.BlogDTO(b.blogId, u.username, b.title, b.content, b.createdAt) " +
                        "FROM Blog b JOIN b.user u WHERE b.blogId = :id",
                BlogDTO.class
        );
        query.setParameter("id", id);
        return query.getSingleResult();
    }


    @Override
    public Blog save(Blog blog) {
        Blog saved = em.merge(blog);
        return saved;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
 Blog blog = em.find(Blog.class, id);
 em.remove(blog);
    }
}
