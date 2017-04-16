package DAOTests;

import com.hws.DAO.UserDAO;
import com.hws.hibernate.models.User;
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
public class UserDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private UserDAO _UserDAO;

    @Before
    public void setUp() {
        _UserDAO = new UserDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _UserDAO.setSessionFactory(_sessionFactory);

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
        String query = "select r from User r";

        List<User> expectedUserList = new ArrayList<User>();
        expectedUserList.add(new User("Lorderot", "124"));
        expectedUserList.add(new User("Lorderot1", "124"));
        expectedUserList.add(new User("Lorderot2", "124"));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedUserList);

        //Act
        List<User> actualUserList = _UserDAO.GetAllUsers();

        //Assert
        assertNotNull(actualUserList);
        assertSame(expectedUserList, actualUserList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID UserId = UUID.randomUUID();
        User expectedUser = new User("Lorderot", "124");

        when(_session.get(User.class, UserId)).thenReturn(expectedUser);

        //Act
        User actualUser = _UserDAO.GetUserById(UserId);

        //Arrange
        assertNotNull(actualUser);
        assertSame(expectedUser, actualUser);
    }

    @Test
    public void TestMethodAddNewUser(){
        //Arrange
        User newUser = new User("Lorderot", "124");

        //Act
        _UserDAO.AddNewUser(newUser);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateUser(){
        //Arrange
        User UserToUpdate = new User("Lorderot", "124");

        //Act
        _UserDAO.UpdateUser(UserToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteUser(){
        //Arrange
        UUID UserId = UUID.randomUUID();
        User UserToDelete = new User("Lorderot", "124");
        UserToDelete.setUserId(UserId);

        when(_session.get(User.class, UserId)).thenReturn(UserToDelete);

        //Act
        _UserDAO.DeleteUserById(UserId);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodGetUserByLogin(){
        //Arrange
        String query = "from User u where u.Login = :login";
        String login = "Lorderot";
        List<User> usersInSystem = new ArrayList<>();
        User expectedUser =new User(login, "124");
        usersInSystem.add(expectedUser);

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(usersInSystem);

        //Act
        User actualUser = _UserDAO.GetUserByLogin(login);

        //Arrange
        assertNotNull(actualUser);
        assertSame(expectedUser, actualUser);
    }
}
