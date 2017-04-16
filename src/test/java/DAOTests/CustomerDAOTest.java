package DAOTests;

import com.hws.DAO.CustomerDAO;
import com.hws.hibernate.models.Address;
import com.hws.hibernate.models.Customer;
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
public class CustomerDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private CustomerDAO _customerDAO;

    @Before
    public void setUp() {
        _customerDAO = new CustomerDAO();

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
    public void TestMethodGetAllCustomers(){
        //Arrange
        String query = "select c from Customer c";

        List<Customer> expectedCustomerList = new ArrayList<>();
        expectedCustomerList.add(new Customer("Ihor", "Golovatskiy", "Test0", new Date()));
        expectedCustomerList.add(new Customer("Nazar", "Bulyha", "Test1", new Date()));
        expectedCustomerList.add(new Customer("Andrii", "Olexiy", "Test2", new Date()));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedCustomerList);

        //Act
        List<Customer> actualCustomerList = _customerDAO.GetAllCustomers();

        //Assert
        assertNotNull(actualCustomerList);
        assertSame(expectedCustomerList, actualCustomerList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID CustomerId = UUID.randomUUID();
        Customer expectedCustomer = new Customer("Ihor", "Golovatskiy", "Test0", new Date());

        when(_session.get(Customer.class, CustomerId)).thenReturn(expectedCustomer);

        //Act
        Customer actualCustomer = _customerDAO.GetCustomerById(CustomerId);

        //Arrange
        assertNotNull(actualCustomer);
        assertSame(expectedCustomer, actualCustomer);
    }

    @Test
    public void TestMethodAddNewCustomer(){
        //Arrange
        Customer newCustomer = new Customer("Ihor", "Golovatskiy", "Test0", new Date());

        //Act
        _customerDAO.AddNewCustomer(newCustomer);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdateCustomer(){
        //Arrange
        Customer CustomerToUpdate = new Customer("Ihor", "Golovatskiy", "Test0", new Date());

        //Act
        _customerDAO.UpdateCustomer(CustomerToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeleteCustomer(){
        //Arrange
        UUID CustomerId = UUID.randomUUID();
        Customer CustomerToDelete = new Customer("Ihor", "Golovatskiy", "Test0", new Date());
        CustomerToDelete.setCustomerId(CustomerId);

        when(_session.get(Address.class, CustomerId)).thenReturn(CustomerToDelete);

        //Act
        _customerDAO.DeleteCustomerById(CustomerId);

        //Arrange
        //No Errors
    }
}
