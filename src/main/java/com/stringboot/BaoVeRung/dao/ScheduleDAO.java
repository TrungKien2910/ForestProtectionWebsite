package com.stringboot.BaoVeRung.dao;

import com.stringboot.BaoVeRung.dto.ScheduleDTO;
import com.stringboot.BaoVeRung.entity.Schedule;

import java.util.List;

public interface ScheduleDAO {
    List<Schedule> findAll();
    Schedule findById(int id);
    List<ScheduleDTO> findByEvent_EventId(int eventId);
    Schedule save(Schedule schedule);
    void deleteById(int id);
}
