package com.stringboot.BaoVeRung.dao;



import com.stringboot.BaoVeRung.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(int id);
    User save(User user);
    void deleteById(int id);
}
