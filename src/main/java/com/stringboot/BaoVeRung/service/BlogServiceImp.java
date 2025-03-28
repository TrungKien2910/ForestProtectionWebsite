package com.stringboot.BaoVeRung.service;

import com.stringboot.BaoVeRung.dto.BlogDTO;
import com.stringboot.BaoVeRung.dao.BlogDAO;
import com.stringboot.BaoVeRung.entity.Blog;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImp implements BlogService {
    private BlogDAO blogDAO;
    @Autowired
    public void setBlogDAO(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }
    @Override
    public List<BlogDTO> findAll() {
        return blogDAO.findAll();
    }

    @Override
    public BlogDTO findById(int id) {
return blogDAO.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        blogDAO.save(blog);
        return blog;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        blogDAO.deleteById(id);

    }
}
