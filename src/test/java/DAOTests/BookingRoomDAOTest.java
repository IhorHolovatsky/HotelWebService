package DAOTests;

import com.hws.DAO.AddressDAO;
import com.hws.DAO.BookingRoomDAO;
import com.hws.hibernate.models.Address;
import com.hws.hibernate.models.BookingRoom;
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
public class BookingRoomDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private BookingRoomDAO _bookingRoomDAO;

    @Before
    public void setUp() {
        _bookingRoomDAO = new BookingRoomDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _bookingRoomDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }

    @Test
    public void TestMethodGetAllBookingRooms(){
        //Arrange
        String query = "select br from BookingRoom br";

        List<BookingRoom> expectedBookingRoomList = new ArrayList<>();
        expectedBookingRoomList.add(new BookingRoom(new Date(), new Date()));
        expectedBookingRoomList.add(new BookingRoom(new Date(), new Date()));
        expectedBookingRoomList.add(new BookingRoom(new Date(), new Date()));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedBookingRoomList);

        //Act
        List<BookingRoom> actualBookingRoomList = _bookingRoomDAO.GetAllBookingRooms();

        //Assert
        assertNotNull(actualBookingRoomList);
        assertSame(expectedBookingRoomList, actualBookingRoomList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID bookingRoomId = UUID.randomUUID();
        BookingRoom expectedBookingRoom = new BookingRoom(new Date(), new Date());

        when(_session.get(BookingRoom.class, bookingRoomId)).thenReturn(expectedBookingRoom);

        //Act
        BookingRoom actualBookingRoom = _bookingRoomDAO.GetBookingRoomById(bookingRoomId);

        //Arrange
        assertNotNull(actualBookingRoom);
        assertSame(expectedBookingRoom, actualBookingRoom);
    }

    @Test
    public void TestMethodAddNewBookingRoom(){
        //Arrange
        BookingRoom newBookingRoom = new BookingRoom(new Date(), new Date());

        //Act
        _bookingRoomDAO.AddNewBookingRoom(newBookingRoom);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateBookingRoom(){
        //Arrange
        BookingRoom bookingRoomToUpdate = new BookingRoom(new Date(), new Date());

        //Act
        _bookingRoomDAO.UpdateBookingRoom(bookingRoomToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteBookingRoom(){
        //Arrange
        UUID bookingRoomId = UUID.randomUUID();
        BookingRoom bookingRoomToDelete = new BookingRoom(new Date(), new Date());
        bookingRoomToDelete.setBookingRoomId(bookingRoomId);

        when(_session.get(Address.class, bookingRoomId)).thenReturn(bookingRoomToDelete);

        //Act
        _bookingRoomDAO.DeleteBookingRoomById(bookingRoomId);

        //Arrange
        //No Errors
    }
}
