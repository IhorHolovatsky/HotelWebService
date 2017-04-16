package com.hws.DAO;

import com.hws.hibernate.models.PaymentMethod;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/16/2017.
 */
public class PaymentMethodDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<PaymentMethod> GetAllPaymentMethods(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from PaymentMethod f");
        return query.list();
    }

    @Transactional
    public PaymentMethod GetPaymentMethodById(UUID paymentMethodId){
        Session session = sessionFactory.getCurrentSession();
        return (PaymentMethod)session.get(PaymentMethod.class, paymentMethodId);
    }

    @Transactional
    public PaymentMethod AddNewPaymentMethod(PaymentMethod paymentMethod){
        paymentMethod.setPaymentMethodId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (PaymentMethod) session.save(paymentMethod);
    }

    @Transactional
    public void UpdatePaymentMethod(PaymentMethod paymentMethod){
        Session session = sessionFactory.getCurrentSession();
        session.update(paymentMethod);
    }

    @Transactional
    public void DeletePaymentMethodById(UUID paymentMethodId){
        PaymentMethod paymentMethodToDelete = this.GetPaymentMethodById(paymentMethodId);
        this.DeletePaymentMethod(paymentMethodToDelete);
    }

    @Transactional
    public void DeletePaymentMethod(PaymentMethod paymentMethodToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(paymentMethodToDelete);
    }
}
