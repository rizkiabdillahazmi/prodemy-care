package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EventDao;
import com.app.model.Event;


@Service
@Transactional
public class EventServiceImpl implements EventService {
	@Autowired
	private EventDao dao;
	
	@Override
	public Event findById(int id) throws Exception {
		return dao.findById(id);
	}

	@Override
	public void deleteById(int id) throws Exception {
		dao.deleteById(id);
		
	}

	@Override
	public void insert(Event event) throws Exception {
		dao.insert(event);
	}

	@Override
	public void update(Event event) throws Exception {
		dao.update(event);
		
	}

	@Override
	public List<Event> findAll() throws Exception {
		return dao.findAll();
	}

}
