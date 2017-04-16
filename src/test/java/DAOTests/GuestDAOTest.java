package DAOTests;

import com.hws.DAO.GuestDAO;
import com.hws.hibernate.models.Address;
import com.hws.hibernate.models.Guest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Ihor on 4/16/2017.
 */
public class GuestDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private GuestDAO _customerDAO;

    @Before
    public void setUp() {
        _customerDAO = new GuestDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _customerDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }

    @Test
    public void TestMethodGetAllGuests(){
        //Arrange
        String query = "select f from Guest f";

        List<Guest> expectedGuestList = new ArrayList<>();
        expectedGuestList.add(new Guest("Ihor", "Golovatskiy", "Test0", new Date()));
        expectedGuestList.add(new Guest("Nazar", "Bulyha", "Test1", new Date()));
        expectedGuestList.add(new Guest("Andrii", "Olexiy", "Test2", new Date()));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedGuestList);

        //Act
        List<Guest> actualGuestList = _customerDAO.GetAllGuests();

        //Assert
        assertNotNull(actualGuestList);
        assertSame(expectedGuestList, actualGuestList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID GuestId = UUID.randomUUID();
        Guest expectedGuest = new Guest("Ihor", "Golovatskiy", "Test0", new Date());

        when(_session.get(Guest.class, GuestId)).thenReturn(expectedGuest);

        //Act
        Guest actualGuest = _customerDAO.GetGuestById(GuestId);

        //Arrange
        assertNotNull(actualGuest);
        assertSame(expectedGuest, actualGuest);
    }

    @Test
    public void TestMethodAddNewGuest(){
        //Arrange
        Guest newGuest = new Guest("Ihor", "Golovatskiy", "Test0", new Date());

        //Act
        _customerDAO.AddNewGuest(newGuest);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateGuest(){
        //Arrange
        Guest GuestToUpdate = new Guest("Ihor", "Golovatskiy", "Test0", new Date());

        //Act
        _customerDAO.UpdateGuest(GuestToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteGuest(){
        //Arrange
        UUID GuestId = UUID.randomUUID();
        Guest GuestToDelete = new Guest("Ihor", "Golovatskiy", "Test0", new Date());
        GuestToDelete.setGuestId(GuestId);

        when(_session.get(Address.class, GuestId)).thenReturn(GuestToDelete);

        //Act
        _customerDAO.DeleteGuestById(GuestId);

        //Arrange
        //No Errors
    }
}
