package com.app.dao;

import java.util.List;

import com.app.model.Event;
import com.app.model.Payment;

public interface EventDao {
	public Event findById(int id) throws Exception;
	public void deleteById(int id) throws Exception;
	public void insert(Event event) throws Exception;
	public void update(Event event) throws Exception;
	public List<Event> findAll() throws Exception;
}
