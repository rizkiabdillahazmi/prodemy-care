package com.app.dao;

import java.util.List;

import com.app.model.Event;
import com.app.model.Payment;

public interface EventDao {
	public Event findById(Long id) throws Exception;
	public void deleteById(Long id) throws Exception;
	public void insert(Event event) throws Exception;
	public void update(Event event) throws Exception;
	public List<Event> findAll() throws Exception;
}
