package com.hws.DAO;

import com.hws.hibernate.models.Payment;
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
public class PaymentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Payment> GetAllPayments(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from Payment f");
        return query.list();
    }

    @Transactional
    public Payment GetPaymentById(UUID paymentId){
        Session session = sessionFactory.getCurrentSession();
        return (Payment)session.get(Payment.class, paymentId);
    }

    @Transactional
    public Payment AddNewPayment(Payment payment){
        payment.setPaymentId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (Payment) session.save(payment);
    }

    @Transactional
    public void UpdatePayment(Payment payment){
        Session session = sessionFactory.getCurrentSession();
        session.update(payment);
    }

    @Transactional
    public void DeletePaymentById(UUID paymentId){
        Payment paymentToDelete = this.GetPaymentById(paymentId);
        this.DeletePayment(paymentToDelete);
    }

    @Transactional
    public void DeletePayment(Payment paymentToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(paymentToDelete);
    }
}
