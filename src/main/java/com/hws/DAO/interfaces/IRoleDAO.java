package com.hws.DAO.interfaces;

import com.hws.hibernate.models.Role;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IRoleDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<Role> GetAllRoles();
    Role GetRoleById(UUID roleId);
    Role AddNewRole(Role role);
    void UpdateRole(Role role);
    void DeleteRoleById(UUID roleId);
    void DeleteRole(Role roleToDelete);
}