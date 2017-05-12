package com.hws.DAO.interfaces;

import com.hws.hibernate.models.User;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 5/7/2017.
 */

public interface IUserDAO {
    User GetUserByLogin(String login);
    void setSessionFactory(SessionFactory sessionFactory);
    List<User> GetAllUsers();
    User GetUserById(UUID userId);
    User AddNewUser(User user);
    void UpdateUser(User user);
    void DeleteUserById(UUID userId);
    void DeleteUser(User userToDelete);
}
