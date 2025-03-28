package com.stringboot.BaoVeRung.service;

import com.stringboot.BaoVeRung.dao.EventDAO;
import com.stringboot.BaoVeRung.entity.Event;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImp implements EventService {
    private EventDAO eventDAO;
    @Autowired
    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }
    @Override
    public List<Event> findAll() {
        return eventDAO.findAll();
    }

    @Override
    public Event findById(int id) {
return eventDAO.findById(id);
    }

    @Override
    public Event save(Event event) {
        eventDAO.save(event);
        return event;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        eventDAO.deleteById(id);

    }
}
