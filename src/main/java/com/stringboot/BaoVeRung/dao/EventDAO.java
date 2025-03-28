package com.stringboot.BaoVeRung.dao;

import com.stringboot.BaoVeRung.entity.Event;

import java.util.List;

public interface EventDAO {
    List<Event> findAll();
    Event findById(int id);
    Event save(Event event);
    void deleteById(int id);
}
