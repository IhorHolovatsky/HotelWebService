package DAOTests;

import com.hws.DAO.RoleDAO;
import com.hws.hibernate.models.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Ihor on 4/16/2017.
 */
public class RoleDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private RoleDAO _RoleDAO;

    @Before
    public void setUp() {
        _RoleDAO = new RoleDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _RoleDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }

    @Test
    public void TestMethodGetAllRoomFacilities(){
        //Arrange
        String query = "select r from Role r";

        List<Role> expectedRoleList = new ArrayList<Role>();
        expectedRoleList.add(new Role("Admin"));
        expectedRoleList.add(new Role("Manager"));
        expectedRoleList.add(new Role("Customer"));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedRoleList);

        //Act
        List<Role> actualRoleList = _RoleDAO.GetAllRoles();

        //Assert
        assertNotNull(actualRoleList);
        assertSame(expectedRoleList, actualRoleList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID RoleId = UUID.randomUUID();
        Role expectedRole = new Role("Customer");

        when(_session.get(Role.class, RoleId)).thenReturn(expectedRole);

        //Act
        Role actualRole = _RoleDAO.GetRoleById(RoleId);

        //Arrange
        assertNotNull(actualRole);
        assertSame(expectedRole, actualRole);
    }

    @Test
    public void TestMethodAddNewRole(){
        //Arrange
        Role newRole = new Role("Customer");

        //Act
        _RoleDAO.AddNewRole(newRole);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateRole(){
        //Arrange
        Role RoleToUpdate = new Role("Customer");

        //Act
        _RoleDAO.UpdateRole(RoleToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteRole(){
        //Arrange
        UUID RoleId = UUID.randomUUID();
        Role RoleToDelete = new Role("Customer");
        RoleToDelete.setRoleId(RoleId);

        when(_session.get(Role.class, RoleId)).thenReturn(RoleToDelete);

        //Act
        _RoleDAO.DeleteRoleById(RoleId);

        //Arrange
        //No Errors
    }
}
