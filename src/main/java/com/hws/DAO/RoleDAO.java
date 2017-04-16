package com.hws.DAO;

import com.hws.hibernate.models.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/16/2017.
 */
public class RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Role> GetAllRoles(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from Role r");
        return query.list();
    }

    @Transactional
    public Role GetRoleById(UUID roleId){
        Session session = sessionFactory.getCurrentSession();
        return (Role)session.get(Role.class, roleId);
    }

    @Transactional
    public Role AddNewRole(Role role){
        role.setRoleId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (Role) session.save(role);
    }

    @Transactional
    public void UpdateRole(Role role){
        Session session = sessionFactory.getCurrentSession();
        session.update(role);
    }

    @Transactional
    public void DeleteRoleById(UUID roleId){
        Role roleToDelete = this.GetRoleById(roleId);
        this.DeleteRole(roleToDelete);
    }

    @Transactional
    public void DeleteRole(Role roleToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(roleToDelete);
    }
}
