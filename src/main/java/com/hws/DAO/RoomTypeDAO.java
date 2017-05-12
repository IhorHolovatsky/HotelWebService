package com.hws.DAO;

import com.hws.DAO.interfaces.IRoomFacilityDAO;
import com.hws.DAO.interfaces.IRoomTypeDAO;
import com.hws.hibernate.models.RoomType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/16/2017.
 */

@Service
public class RoomTypeDAO implements IRoomTypeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<RoomType> GetAllRoomTypes(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from RoomType f");
        return query.list();
    }

    @Transactional
    public RoomType GetRoomTypeById(UUID roomTypeId){
        Session session = sessionFactory.getCurrentSession();
        return (RoomType)session.get(RoomType.class, roomTypeId);
    }

    @Transactional
    public RoomType AddNewRoomType(RoomType roomType){
        roomType.setRoomTypeId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (RoomType) session.save(roomType);
    }

    @Transactional
    public void UpdateRoomType(RoomType roomType){
        Session session = sessionFactory.getCurrentSession();
        session.update(roomType);
    }

    @Transactional
    public void DeleteRoomTypeById(UUID roomTypeId){
        RoomType roomTypeToDelete = this.GetRoomTypeById(roomTypeId);
        this.DeleteRoomType(roomTypeToDelete);
    }

    @Transactional
    public void DeleteRoomType(RoomType roomTypeToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(roomTypeToDelete);
    }
}
