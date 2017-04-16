package com.hws.DAO;

import com.hws.hibernate.models.Facility;
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
public class FacilityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Facility> GetAllFacilities(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from Facility f");
        return query.list();
    }

    @Transactional
    public Facility GetFacilityById(UUID facilityId){
        Session session = sessionFactory.getCurrentSession();
        return (Facility)session.get(Facility.class, facilityId);
    }

    @Transactional
    public Facility AddNewFacility(Facility facility){
        facility.setFacilityId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (Facility) session.save(facility);
    }

    @Transactional
    public void UpdateFacility(Facility facility){
        Session session = sessionFactory.getCurrentSession();
        session.update(facility);
    }

    @Transactional
    public void DeleteFacilityById(UUID facilityId){
        Facility facilityToDelete = this.GetFacilityById(facilityId);
        this.DeleteFacility(facilityToDelete);
    }

    @Transactional
    public void DeleteFacility(Facility facilityToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(facilityToDelete);
    }

}
