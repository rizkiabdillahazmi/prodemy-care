package com.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.PaymentDao;
import com.app.model.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public Payment findById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		Payment pay = (Payment) session.get(Payment.class, id);
		return pay;
	}

	@Override
	public void deleteById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		Payment pay = (Payment) session.load(Payment.class, id);
		session.delete(pay);
		
	}

	@Override
	public void insert(Payment pay) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(pay);
		logger.debug("Payment saved -> {0}", pay);
	}

	@Override
	public void update(Payment pay) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(pay);
		logger.debug("Payment updated -> {0}", pay);
		
	}

	@Override
	public List<Payment> findAll() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<Payment> result = session.createQuery("from Payment").list();
		return result;
	}

}
