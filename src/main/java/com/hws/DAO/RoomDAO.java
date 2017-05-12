package com.hws.DAO;

import com.hws.DAO.interfaces.IRoomDAO;
import com.hws.hibernate.models.Room;
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
public class RoomDAO implements IRoomDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Room> GetAllRooms(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from Room f");
        return query.list();
    }

    @Transactional
    public Room GetRoomById(UUID roomId){
        Session session = sessionFactory.getCurrentSession();
        return (Room)session.get(Room.class, roomId);
    }

    @Transactional
    public Room AddNewRoom(Room room){
        room.setRoomId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (Room) session.save(room);
    }

    @Transactional
    public void UpdateRoom(Room room){
        Session session = sessionFactory.getCurrentSession();
        session.update(room);
    }

    @Transactional
    public void DeleteRoomById(UUID roomId){
        Room roomToDelete = this.GetRoomById(roomId);
        this.DeleteRoom(roomToDelete);
    }

    @Transactional
    public void DeleteRoom(Room roomToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(roomToDelete);
    }
}
