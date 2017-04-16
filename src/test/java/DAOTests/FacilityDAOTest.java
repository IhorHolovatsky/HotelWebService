package DAOTests;

import com.hws.DAO.FacilityDAO;
import com.hws.hibernate.models.Address;
import com.hws.hibernate.models.Facility;
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
public class FacilityDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private FacilityDAO _customerDAO;

    @Before
    public void setUp() {
        _customerDAO = new FacilityDAO();

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
    public void TestMethodGetAllFacilitys(){
        //Arrange
        String query = "select f from Facility f";

        List<Facility> expectedFacilityList = new ArrayList<>();
        expectedFacilityList.add(new Facility("WiFi"));
        expectedFacilityList.add(new Facility("TV"));
        expectedFacilityList.add(new Facility("Bed"));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedFacilityList);

        //Act
        List<Facility> actualFacilityList = _customerDAO.GetAllFacilities();

        //Assert
        assertNotNull(actualFacilityList);
        assertSame(expectedFacilityList, actualFacilityList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID FacilityId = UUID.randomUUID();
        Facility expectedFacility = new Facility("WiFi");

        when(_session.get(Facility.class, FacilityId)).thenReturn(expectedFacility);

        //Act
        Facility actualFacility = _customerDAO.GetFacilityById(FacilityId);

        //Arrange
        assertNotNull(actualFacility);
        assertSame(expectedFacility, actualFacility);
    }

    @Test
    public void TestMethodAddNewFacility(){
        //Arrange
        Facility newFacility = new Facility("WiFi");

        //Act
        _customerDAO.AddNewFacility(newFacility);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateFacility(){
        //Arrange
        Facility FacilityToUpdate = new Facility("WiFi");

        //Act
        _customerDAO.UpdateFacility(FacilityToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteFacility(){
        //Arrange
        UUID FacilityId = UUID.randomUUID();
        Facility FacilityToDelete = new Facility("WiFi");
        FacilityToDelete.setFacilityId(FacilityId);

        when(_session.get(Address.class, FacilityId)).thenReturn(FacilityToDelete);

        //Act
        _customerDAO.DeleteFacilityById(FacilityId);

        //Arrange
        //No Errors
    }
}
