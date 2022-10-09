package com.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.DonationMemberDao;
import com.app.model.DonationMember;
import com.app.model.ListDonatur;

@Repository
public class DonationMemberDaoImpl implements DonationMemberDao {
    private static final Logger logger = LoggerFactory.getLogger(DonaturDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public DonationMember findById(Long id) throws Exception {
        Session session = this.sessionFactory.getCurrentSession();
        DonationMember dm = (DonationMember) session.get(DonationMember.class, id);
        return dm; 
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Session session = this.sessionFactory.getCurrentSession();
        DonationMember dm = (DonationMember) session.load(DonationMember.class, id);
        session.delete(dm);
    }

    @Override
    public void save(DonationMember donationMember) throws Exception {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(donationMember);
        logger.debug("Donation Member saved -> {0}", donationMember);
    }

    @Override
    public void update(DonationMember donationMember) throws Exception {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(donationMember);
        logger.debug("Donation Member Update -> {0}", donationMember);
    }

    @Override
    public List<DonationMember> findAll() throws Exception {
        Session session = this.sessionFactory.getCurrentSession();
        List<DonationMember> result = session.createQuery("from DonationMember").list();
        return result;
    }

    @Override
    public List<DonationMember> findAllById(Long id) throws Exception {
        Session session = this.sessionFactory.getCurrentSession();
        List<DonationMember> result = session.createQuery("from DonationMember dm where dm.donationId="+id).list();
        return result;
    }

}
