package com.stringboot.BaoVeRung.dao;

import com.stringboot.BaoVeRung.dto.ScheduleDTO;
import com.stringboot.BaoVeRung.entity.Schedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class ScheduleDAOImp implements ScheduleDAO {
    private EntityManager em;
    @Autowired
    public ScheduleDAOImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Schedule> findAll() {
    TypedQuery<Schedule> query = em.createQuery("from Schedule", Schedule.class);
    return query.getResultList();
    }

    @Override
    public Schedule findById(int id) {
        return em.find(Schedule.class, id);
    }

    @Override
    public List<ScheduleDTO> findByEvent_EventId(int eventId) {
        TypedQuery<ScheduleDTO> query = em.createQuery(
                "SELECT new com.stringboot.BaoVeRung.dto.ScheduleDTO(s.event.eventId, s.event.eventName, s.event.slogan, s.taskName, s.taskDescription, s.startTime, s.endTime, s.event.img) " +
                        "FROM Schedule s WHERE s.event.eventId = :eventId",
                ScheduleDTO.class
        );
        query.setParameter("eventId", eventId);
        return query.getResultList();
    }


    @Override
    public Schedule save(Schedule schedule) {
        Schedule saved = em.merge(schedule);
        return saved;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
 Schedule schedule = em.find(Schedule.class, id);
 em.remove(schedule);
    }
}
