package DAOTests;

import com.hws.DAO.RoomTypeDAO;
import com.hws.hibernate.models.Address;
import com.hws.hibernate.models.RoomType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
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
public class RoomTypeDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private RoomTypeDAO _roomTypeDAO;

    @Before
    public void setUp() {
        _roomTypeDAO = new RoomTypeDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _roomTypeDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }

    @Test
    public void TestMethodGetAllRoomTypes(){
        //Arrange
        String query = "select f from RoomType f";

        List<RoomType> expectedRoomTypeList = new ArrayList<>();
        expectedRoomTypeList.add(new RoomType("Lux", 3));
        expectedRoomTypeList.add(new RoomType("Business", 2));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedRoomTypeList);

        //Act
        List<RoomType> actualRoomTypeList = _roomTypeDAO.GetAllRoomTypes();

        //Assert
        assertNotNull(actualRoomTypeList);
        assertSame(expectedRoomTypeList, actualRoomTypeList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID RoomTypeId = UUID.randomUUID();
        RoomType expectedRoomType = new RoomType("Business", 2);

        when(_session.get(RoomType.class, RoomTypeId)).thenReturn(expectedRoomType);

        //Act
        RoomType actualRoomType = _roomTypeDAO.GetRoomTypeById(RoomTypeId);

        //Arrange
        assertNotNull(actualRoomType);
        assertSame(expectedRoomType, actualRoomType);
    }

    @Test
    public void TestMethodAddNewRoomType(){
        //Arrange
        RoomType newRoomType = new RoomType("Business", 2);

        //Act
        _roomTypeDAO.AddNewRoomType(newRoomType);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateRoomType(){
        //Arrange
        RoomType RoomTypeToUpdate = new RoomType("Business", 2);

        //Act
        _roomTypeDAO.UpdateRoomType(RoomTypeToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteRoomType(){
        //Arrange
        UUID RoomTypeId = UUID.randomUUID();
        RoomType RoomTypeToDelete = new RoomType("Business", 2);
        RoomTypeToDelete.setRoomTypeId(RoomTypeId);

        when(_session.get(Address.class, RoomTypeId)).thenReturn(RoomTypeToDelete);

        //Act
        _roomTypeDAO.DeleteRoomTypeById(RoomTypeId);

        //Arrange
        //No Errors
    }
}
