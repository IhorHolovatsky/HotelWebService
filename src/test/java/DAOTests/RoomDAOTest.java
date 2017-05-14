package DAOTests;

import com.hws.DAO.RoomDAO;
import com.hws.hibernate.models.Address;
import com.hws.hibernate.models.Room;
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
public class RoomDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private RoomDAO _roomDAO;
    UUID RoomId = UUID.randomUUID();
    UUID HotelId = UUID.randomUUID();
    UUID RoomTypeId = UUID.randomUUID();

    @Before
    public void setUp() {
        _roomDAO = new RoomDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _roomDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }
/*
    @Test
    public void TestMethodGetAllRooms(){
        //Arrange
        String query = "select f from Room f";

        List<Room> expectedRoomList = new ArrayList<>();
        expectedRoomList.add(new Room(RoomId, HotelId, RoomTypeId, ));
        expectedRoomList.add(new Room(2,210));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedRoomList);

        //Act
        List<Room> actualRoomList = _roomDAO.GetAllRooms();

        //Assert
        assertNotNull(actualRoomList);
        assertSame(expectedRoomList, actualRoomList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID RoomId = UUID.randomUUID();
        Room expectedRoom = new Room(5,310);

        when(_session.get(Room.class, RoomId)).thenReturn(expectedRoom);

        //Act
        Room actualRoom = _roomDAO.GetRoomById(RoomId);

        //Arrange
        assertNotNull(actualRoom);
        assertSame(expectedRoom, actualRoom);
    }

    @Test
    public void TestMethodAddNewRoom(){
        //Arrange
        Room newRoom = new Room(5,310);

        //Act
        _roomDAO.AddNewRoom(newRoom);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateRoom(){
        //Arrange
        Room RoomToUpdate = new Room(5,310);

        //Act
        _roomDAO.UpdateRoom(RoomToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteRoom(){
        //Arrange
        UUID RoomId = UUID.randomUUID();
        Room RoomToDelete = new Room(5,310);
        RoomToDelete.setRoomId(RoomId);

        when(_session.get(Address.class, RoomId)).thenReturn(RoomToDelete);

        //Act
        _roomDAO.DeleteRoomById(RoomId);

        //Arrange
        //No Errors
    }
*/
}
