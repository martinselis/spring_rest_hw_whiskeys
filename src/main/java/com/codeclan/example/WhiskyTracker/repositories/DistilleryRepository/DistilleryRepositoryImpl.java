package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {


    // doesnt work//
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> getDistilleriesWith12YearWhiskeys(int age) {
        List<Distillery> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whiskeyAlias");
            cr.add(Restrictions.eq("whiskeyAlias.year", age));
            result = cr.list();
        } catch (HibernateException exc){
            exc.printStackTrace();
        } finally {
            return result;
        }
    }

}
