package DAOTests;

import com.hws.DAO.AddressDAO;
import com.hws.hibernate.models.Address;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by Ihor on 4/15/2017.
 */
public class AddressDaoTest {

    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private AddressDAO _addressDAO;

    @Before
    public void setUp() {
        _addressDAO = new AddressDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _addressDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }

    @Test
    public void TestMethodGetAllAddresses(){
        //Arrange
        String query = "select a from Address a";

        List<Address> expectedAddressList = new ArrayList<Address>();
        expectedAddressList.add(new Address("Kyiv", "Ukraine", "0509134081", "Yangela 20", "03057"));
        expectedAddressList.add(new Address("Chernivtsi", "Ukraine", "0509134081", "Korduby 20", "58001"));
        expectedAddressList.add(new Address("Kyiv", "Ukraine", "0509134081", "Vyshgorodska 20", "4125"));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedAddressList);

        //Act
        List<Address> actualAddressList = _addressDAO.GetAllAddresses();

        //Assert
        assertNotNull(actualAddressList);
        assertSame(expectedAddressList, actualAddressList);
    }

}
