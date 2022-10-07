package com.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.EventDao;
import com.app.model.Event;

@Repository
public class EventDaoImp implements EventDao{
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public Event findById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		Event event = (Event) session.get(Event.class, id);
		return event;
	}

	@Override
	public void deleteById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		Event event = (Event) session.load(Event.class, id);
		session.delete(event);
		
	}

	@Override
	public void insert(Event event) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(event);
		logger.debug("Event saved -> {0}", event);
	}

	@Override
	public void update(Event event) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(event);
		logger.debug("Event updated -> {0}", event);
	}

	@Override
	public List<Event> findAll() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<Event> result = session.createQuery("from Event").list();
		return result;
	}
	

}
