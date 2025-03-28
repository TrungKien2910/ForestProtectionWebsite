package com.stringboot.BaoVeRung.service;


import com.stringboot.BaoVeRung.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    User save(User user);
    void deleteById(int id);
}
