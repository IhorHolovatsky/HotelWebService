package com.hws.DAO;

import com.hws.hibernate.models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/16/2017.
 */
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<User> GetAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from User r");
        return query.list();
    }

    @Transactional
    public User GetUserById(UUID userId){
        Session session = sessionFactory.getCurrentSession();
        return (User)session.get(User.class, userId);
    }

    @Transactional
    public User GetUserByLogin(String login){
        List<User> userList = new ArrayList<User>();

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User u where u.Login = :login");
        query.setParameter("login", login);
        userList = query.list();

        if (userList.size() == 0){
            return null;
        }

        return userList.get(0);
    }

    @Transactional
    public User AddNewUser(User user){
        user.setUserId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (User) session.save(user);
    }

    @Transactional
    public void UpdateUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Transactional
    public void DeleteUserById(UUID userId){
        User userToDelete = this.GetUserById(userId);
        this.DeleteUser(userToDelete);
    }

    @Transactional
    public void DeleteUser(User userToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(userToDelete);
    }
}
