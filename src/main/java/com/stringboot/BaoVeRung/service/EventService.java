package com.stringboot.BaoVeRung.service;

import com.stringboot.BaoVeRung.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> findAll();
    Event findById(int id);
    Event save(Event event);
    void deleteById(int id);
}
