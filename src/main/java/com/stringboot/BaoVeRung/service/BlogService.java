package com.stringboot.BaoVeRung.service;


import com.stringboot.BaoVeRung.dto.BlogDTO;
import com.stringboot.BaoVeRung.entity.Blog;

import java.util.List;

public interface BlogService {
    List<BlogDTO> findAll();
    BlogDTO findById(int id);
    Blog save(Blog blog);
    void deleteById(int id);
}
