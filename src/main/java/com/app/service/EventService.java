package com.app.service;

import java.util.List;

import com.app.model.Event;

public interface EventService {
	public Event findById(Long id) throws Exception;
	public void deleteById(Long id) throws Exception;
	public void insert(Event event) throws Exception;
	public void update(Event event) throws Exception;
	public List<Event> findAll() throws Exception;
}
