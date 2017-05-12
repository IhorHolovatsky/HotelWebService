package com.hws.DAO.interfaces;

import com.hws.hibernate.models.Facility;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IFacilityDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<Facility> GetAllFacilities();
    Facility GetFacilityById(UUID facilityId);
    Facility AddNewFacility(Facility facility);
    void UpdateFacility(Facility facility);
    void DeleteFacilityById(UUID facilityId);
    void DeleteFacility(Facility facilityToDelete);
}