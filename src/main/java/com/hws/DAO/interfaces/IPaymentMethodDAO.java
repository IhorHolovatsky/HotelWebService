package com.hws.DAO.interfaces;

import com.hws.hibernate.models.PaymentMethod;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IPaymentMethodDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<PaymentMethod> GetAllPaymentMethods();
    PaymentMethod GetPaymentMethodById(UUID paymentMethodId);
    PaymentMethod AddNewPaymentMethod(PaymentMethod paymentMethod);
    void UpdatePaymentMethod(PaymentMethod paymentMethod);
    void DeletePaymentMethodById(UUID paymentMethodId);
    void DeletePaymentMethod(PaymentMethod paymentMethodToDelete);
}