package DAOTests;

import com.hws.DAO.PaymentDAO;
import com.hws.hibernate.models.Address;
import com.hws.hibernate.models.Payment;
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
public class PaymentDAOTest {
    private SessionFactory _sessionFactory;
    private Session _session;
    private Query _query;
    private PaymentDAO _paymentDAO;

    @Before
    public void setUp() {
        _paymentDAO = new PaymentDAO();

        _sessionFactory = mock(SessionFactory.class);
        _session = mock(Session.class);
        _query = mock(Query.class);

        _paymentDAO.setSessionFactory(_sessionFactory);

        when(_sessionFactory.getCurrentSession()).thenReturn(_session);
    }

    @Test
    public void TestMock(){
        Session actualSession = _sessionFactory.getCurrentSession();
        assertSame(_session, actualSession);
    }

    @Test
    public void TestMethodGetAllPayments(){
        //Arrange
        String query = "select f from Payment f";

        List<Payment> expectedPaymentList = new ArrayList<>();
        expectedPaymentList.add(new Payment(UUID.randomUUID(),UUID.randomUUID(),"Test Comment", new Date(), new BigDecimal(50)));
        expectedPaymentList.add(new Payment(UUID.randomUUID(),UUID.randomUUID(),"Test Comment", new Date(), new BigDecimal(50)));
        expectedPaymentList.add(new Payment(UUID.randomUUID(),UUID.randomUUID(),"Test Comment", new Date(), new BigDecimal(50)));

        when(_session.createQuery(query)).thenReturn(_query);
        when(_query.list()).thenReturn(expectedPaymentList);

        //Act
        List<Payment> actualPaymentList = _paymentDAO.GetAllPayments();

        //Assert
        assertNotNull(actualPaymentList);
        assertSame(expectedPaymentList, actualPaymentList);
    }

    @Test
    public void TestMethodGetById(){
        //Arrange
        UUID PaymentId = UUID.randomUUID();
        Payment expectedPayment = new Payment(UUID.randomUUID(),UUID.randomUUID(),"Test Comment", new Date(), new BigDecimal(50));

        when(_session.get(Payment.class, PaymentId)).thenReturn(expectedPayment);

        //Act
        Payment actualPayment = _paymentDAO.GetPaymentById(PaymentId);

        //Arrange
        assertNotNull(actualPayment);
        assertSame(expectedPayment, actualPayment);
    }

    @Test
    public void TestMethodAddNewPayment(){
        //Arrange
        Payment newPayment = new Payment(UUID.randomUUID(),UUID.randomUUID(),"Test Comment", new Date(), new BigDecimal(50));

        //Act
        _paymentDAO.AddNewPayment(newPayment);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodUpdatePayment(){
        //Arrange
        Payment PaymentToUpdate = new Payment(UUID.randomUUID(),UUID.randomUUID(),"Test Comment", new Date(), new BigDecimal(50));

        //Act
        _paymentDAO.UpdatePayment(PaymentToUpdate);

        //Arrange
        //No Errors
    }

    @Test
    public void TestMethodDeletePayment(){
        //Arrange
        UUID PaymentId = UUID.randomUUID();
        Payment PaymentToDelete = new Payment(UUID.randomUUID(),UUID.randomUUID(),"Test Comment", new Date(), new BigDecimal(50));
        PaymentToDelete.setPaymentId(PaymentId);

        when(_session.get(Address.class, PaymentId)).thenReturn(PaymentToDelete);

        //Act
        _paymentDAO.DeletePaymentById(PaymentId);

        //Arrange
        //No Errors
    }
}
