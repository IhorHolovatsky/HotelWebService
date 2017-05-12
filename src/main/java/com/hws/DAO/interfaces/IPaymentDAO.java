package com.hws.DAO.interfaces;

import com.hws.hibernate.models.Payment;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IPaymentDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<Payment> GetAllPayments();
    Payment GetPaymentById(UUID paymentId);
    Payment AddNewPayment(Payment payment);
    void UpdatePayment(Payment payment);
    void DeletePaymentById(UUID paymentId);
    void DeletePayment(Payment paymentToDelete);
}