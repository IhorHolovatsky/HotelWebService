package DAOTests;

import com.hws.DAO.BookingDAO;
import com.hws.hibernate.models.Booking;
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
 * Created by nazar on 4/16/2017.
 */
public class BookingDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private BookingDAO _bookingDAO;

    @Before
    public void setUp() {
        _bookingDAO = new BookingDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _bookingDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }

//    @Test
//    public void TestMethodGetAllBooking(){
//        //Arrange
//        String query = "select b from Booking b";
//
//        List<Booking> expectedBookingList = new ArrayList<Booking>();
//        expectedBookingList.add(new Booking(new Date(), "My comment about first booking"));
//        expectedBookingList.add(new Booking(new Date(), "His comment stupid abort booking"));
//        expectedBookingList.add(new Booking(new Date(), "Nothing to comment here"));
//
//        when(_session.createQuery(query)).thenReturn(_query);
//        when(_query.list()).thenReturn(expectedBookingList);
//
//        //Act
//        List<Booking> actualBookingList = _bookingDAO.GetAllBookings();
//
//        //Assert
//        assertNotNull(actualBookingList);
//        assertSame(expectedBookingList, actualBookingList);
//    }
//
//    @Test
//    public void TestMethodGetById(){
//        //Arrange
//        UUID BookingId = UUID.randomUUID();
//        Booking expectedBooking = new Booking(new Date(), "My comment about first booking");
//
//        when(_session.get(Booking.class, BookingId)).thenReturn(expectedBooking);
//
//        //Act
//        Booking actualBooking = _bookingDAO.GetBookingById(BookingId);
//
//        //Arrange
//        assertNotNull(actualBooking);
//        assertSame(expectedBooking, actualBooking);
//    }
//
//    @Test
//    public void TestMethodAddNewBooking(){
//        //Arrange
//        Booking newBooking = new Booking(new Date(), "Nothing to comment here");
//
//        //Act
//        _bookingDAO.AddNewBooking(newBooking);
//
//        //Arrange
//        //No Errors
//    }
//
//    @Test
//    public void TestMethodUpdateBooking(){
//        //Arrange
//        Booking BookingToUpdate = new Booking(new Date(), "Nothing to comment here");
//
//        //Act
//        _bookingDAO.UpdateBooking(BookingToUpdate);
//
//        //Arrange
//        //No Errors
//    }
//
//    @Test
//    public void TestMethodDeleteBooking(){
//        //Arrange
//        UUID BookingId = UUID.randomUUID();
//        Booking BookingToDelete = new Booking(new Date(), "Here am I and my comment");
//        BookingToDelete.setBookingId(BookingId);
//
//        when(_session.get(Booking.class, BookingId)).thenReturn(BookingToDelete);
//
//        //Act
//        _bookingDAO.DeleteBookingById(BookingId);
//
//        //Arrange
//        //No Errors
//    }
}

