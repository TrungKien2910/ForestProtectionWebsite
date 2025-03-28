package com.stringboot.BaoVeRung.dao;


import com.stringboot.BaoVeRung.dto.BlogDTO;
import com.stringboot.BaoVeRung.entity.Blog;

import java.util.List;

public interface BlogDAO {
    List<BlogDTO> findAll();
    BlogDTO findById(int id);
    Blog save(Blog blog);
    void deleteById(int id);
}
