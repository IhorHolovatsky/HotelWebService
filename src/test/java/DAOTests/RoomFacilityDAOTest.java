package DAOTests;

import com.hws.DAO.RoomFacilityDAO;
import com.hws.hibernate.models.RoomFacility;
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
    private RoomFacilityDAO _RoomFacilityDAO;

    @Before
    public void setUp() {
        _RoomFacilityDAO = new RoomFacilityDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _RoomFacilityDAO.setSessionFactory(_sessionFactory);

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
        String query = "select r from RoomFacility r";

        List<RoomFacility> expectedRoomFacilityList = new ArrayList<RoomFacility>();
        expectedRoomFacilityList.add(new RoomFacility("Comfort"));
        expectedRoomFacilityList.add(new RoomFacility("Usability"));
        expectedRoomFacilityList.add(new RoomFacility("Luxoft"));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedRoomFacilityList);

        //Act
        List<RoomFacility> actualRoomFacilityList = _RoomFacilityDAO.GetAllRoomFacilities();

        //Assert
        assertNotNull(actualRoomFacilityList);
        assertSame(expectedRoomFacilityList, actualRoomFacilityList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID RoomFacilityId = UUID.randomUUID();
        RoomFacility expectedRoomFacility = new RoomFacility("Comfort");

        when(_session.get(RoomFacility.class, RoomFacilityId)).thenReturn(expectedRoomFacility);

        //Act
        RoomFacility actualRoomFacility = _RoomFacilityDAO.GetRoomFacilityById(RoomFacilityId);

        //Arrange
        assertNotNull(actualRoomFacility);
        assertSame(expectedRoomFacility, actualRoomFacility);
    }

    @Test
    public void TestMethodAddNewRoomFacility(){
        //Arrange
        RoomFacility newRoomFacility = new RoomFacility("Usability");

        //Act
        _RoomFacilityDAO.AddNewRoomFacility(newRoomFacility);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateRoomFacility(){
        //Arrange
        RoomFacility RoomFacilityToUpdate = new RoomFacility("Luxoft");

        //Act
        _RoomFacilityDAO.UpdateRoomFacility(RoomFacilityToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteRoomFacility(){
        //Arrange
        UUID RoomFacilityId = UUID.randomUUID();
        RoomFacility RoomFacilityToDelete = new RoomFacility("SoftServe");
        RoomFacilityToDelete.setRoomFacilityId(RoomFacilityId);

        when(_session.get(RoomFacility.class, RoomFacilityId)).thenReturn(RoomFacilityToDelete);

        //Act
        _RoomFacilityDAO.DeleteRoomFacilityById(RoomFacilityId);

        //Arrange
        //No Errors
    }
}