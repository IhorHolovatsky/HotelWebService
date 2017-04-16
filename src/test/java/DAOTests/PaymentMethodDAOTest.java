package DAOTests;

import com.hws.DAO.PaymentMethodDAO;
import com.hws.hibernate.models.Address;
import com.hws.hibernate.models.PaymentMethod;
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
public class PaymentMethodDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private PaymentMethodDAO _paymentMethodDAO;

    @Before
    public void setUp() {
        _paymentMethodDAO = new PaymentMethodDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _paymentMethodDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }

    @Test
    public void TestMethodGetAllPaymentMethods(){
        //Arrange
        String query = "select f from PaymentMethod f";

        List<PaymentMethod> expectedPaymentMethodList = new ArrayList<>();
        expectedPaymentMethodList.add(new PaymentMethod("Cash"));
        expectedPaymentMethodList.add(new PaymentMethod("VISA"));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedPaymentMethodList);

        //Act
        List<PaymentMethod> actualPaymentMethodList = _paymentMethodDAO.GetAllPaymentMethods();

        //Assert
        assertNotNull(actualPaymentMethodList);
        assertSame(expectedPaymentMethodList, actualPaymentMethodList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID PaymentMethodId = UUID.randomUUID();
        PaymentMethod expectedPaymentMethod = new PaymentMethod("VISA");

        when(_session.get(PaymentMethod.class, PaymentMethodId)).thenReturn(expectedPaymentMethod);

        //Act
        PaymentMethod actualPaymentMethod = _paymentMethodDAO.GetPaymentMethodById(PaymentMethodId);

        //Arrange
        assertNotNull(actualPaymentMethod);
        assertSame(expectedPaymentMethod, actualPaymentMethod);
    }

    @Test
    public void TestMethodAddNewPaymentMethod(){
        //Arrange
        PaymentMethod newPaymentMethod = new PaymentMethod("VISA");

        //Act
        _paymentMethodDAO.AddNewPaymentMethod(newPaymentMethod);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdatePaymentMethod(){
        //Arrange
        PaymentMethod PaymentMethodToUpdate = new PaymentMethod("VISA");

        //Act
        _paymentMethodDAO.UpdatePaymentMethod(PaymentMethodToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeletePaymentMethod(){
        //Arrange
        UUID PaymentMethodId = UUID.randomUUID();
        PaymentMethod PaymentMethodToDelete = new PaymentMethod("VISA");
        PaymentMethodToDelete.setPaymentMethodId(PaymentMethodId);

        when(_session.get(Address.class, PaymentMethodId)).thenReturn(PaymentMethodToDelete);

        //Act
        _paymentMethodDAO.DeletePaymentMethodById(PaymentMethodId);

        //Arrange
        //No Errors
    }
}
