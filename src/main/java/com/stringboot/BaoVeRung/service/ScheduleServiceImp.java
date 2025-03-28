package com.stringboot.BaoVeRung.service;

import com.stringboot.BaoVeRung.dao.ScheduleDAO;
import com.stringboot.BaoVeRung.dto.ScheduleDTO;
import com.stringboot.BaoVeRung.entity.Schedule;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImp implements ScheduleService {
    private ScheduleDAO scheduleDAO;
    @Autowired
    public void setScheduleDAO(ScheduleDAO scheduleDAO) {
        this.scheduleDAO = scheduleDAO;
    }
    @Override
    public List<Schedule> findAll() {
        return scheduleDAO.findAll();
    }

    @Override
    public Schedule findById(int id) {
return scheduleDAO.findById(id);
    }


    @Override
    public List<ScheduleDTO> findByEvent_EventId(int eventId){
        return scheduleDAO.findByEvent_EventId(eventId);
    }

    @Override
    public Schedule save(Schedule schedule) {
        scheduleDAO.save(schedule);
        return schedule;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        scheduleDAO.deleteById(id);

    }
}
