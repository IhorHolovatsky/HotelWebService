package DAOTests;

import com.hws.DAO.HotelDAO;
import com.hws.hibernate.models.Hotel;
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
 * Created by nazar on 4/16/2017.
 */
public class RoomFacilityDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private HotelDAO _hotelDAO;

    @Before
    public void setUp() {
        _hotelDAO = new HotelDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _hotelDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }

    @Test
    public void TestMethodGetAllHotel(){
        //Arrange
        String query = "select h from Hotel h";

        List<Hotel> expectedHotelList = new ArrayList<Hotel>();
        expectedHotelList.add(new Hotel("NVidia", "My videocard"));
        expectedHotelList.add(new Hotel("AMD", "MY fire"));
        expectedHotelList.add(new Hotel("Intel", "My energy"));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedHotelList);

        //Act
        List<Hotel> actualHotelList = _hotelDAO.GetAllHotels();

        //Assert
        assertNotNull(actualHotelList);
        assertSame(expectedHotelList, actualHotelList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID HotelId = UUID.randomUUID();
        Hotel expectedHotel = new Hotel("NVidia", "My videocard");

        when(_session.get(Hotel.class, HotelId)).thenReturn(expectedHotel);

        //Act
        Hotel actualHotel = _hotelDAO.GetHotelById(HotelId);

        //Arrange
        assertNotNull(actualHotel);
        assertSame(expectedHotel, actualHotel);
    }

    @Test
    public void TestMethodAddNewHotel(){
        //Arrange
        Hotel newHotel = new Hotel("AMD", "MY fire");

        //Act
        _hotelDAO.AddNewHotel(newHotel);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateHotel(){
        //Arrange
        Hotel HotelToUpdate = new Hotel("Intel", "My energy");

        //Act
        _hotelDAO.UpdateHotel(HotelToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteHotel(){
        //Arrange
        UUID HotelId = UUID.randomUUID();
        Hotel HotelToDelete = new Hotel("BNM", "My thinks");
        HotelToDelete.setHotelId(HotelId);

        when(_session.get(Hotel.class, HotelId)).thenReturn(HotelToDelete);

        //Act
        _hotelDAO.DeleteHotelById(HotelId);

        //Arrange
        //No Errors
    }
}