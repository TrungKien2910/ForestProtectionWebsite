package com.stringboot.BaoVeRung.service;

import com.stringboot.BaoVeRung.dao.UserDAO;
import com.stringboot.BaoVeRung.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDAO userDAO;
    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int id) {
return userDAO.findById(id);
    }

    @Override
    public User save(User user) {
        userDAO.save(user);
        return user;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userDAO.deleteById(id);

    }
}
