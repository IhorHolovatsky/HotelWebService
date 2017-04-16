package com.hws.DAO;

import com.hws.hibernate.models.RoomFacility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
/**
 * Created by nazar on 4/16/2017.
 */
public class RoomFacilityDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<RoomFacility> GetAllRoomFacilities(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from RoomFacility r");
        return query.list();
    }

    @Transactional
    public RoomFacility GetRoomFacilityById(UUID RoomFacilityId){
        Session session = sessionFactory.getCurrentSession();
        return (RoomFacility)session.get(RoomFacility.class, RoomFacilityId);
    }

    @Transactional
    public RoomFacility AddNewRoomFacility(RoomFacility RoomFacility){
        RoomFacility.setRoomFacilityId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (RoomFacility) session.save(RoomFacility);
    }

    @Transactional
    public void UpdateRoomFacility(RoomFacility RoomFacility){
        Session session = sessionFactory.getCurrentSession();
        session.update(RoomFacility);
    }

    @Transactional
    public void DeleteRoomFacilityById(UUID RoomFacilityId){
        RoomFacility RoomFacilityToDelete = this.GetRoomFacilityById(RoomFacilityId);
        this.DeleteRoomFacility(RoomFacilityToDelete);
    }

    @Transactional
    public void DeleteRoomFacility(RoomFacility RoomFacilityToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(RoomFacilityToDelete);
    }
}
