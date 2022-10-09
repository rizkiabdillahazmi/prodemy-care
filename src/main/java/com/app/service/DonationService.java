package com.app.service;

import java.util.List;

import com.app.model.Donation;

public interface DonationService {
	public Donation findById(Long id) throws Exception;
	public void deleteById(Long id) throws Exception;
	public void save(Donation donation) throws Exception;
	public void update(Donation donation) throws Exception;
	public List<Donation> findAll() throws Exception;
	public List<Donation> homeFindAll() throws Exception;
}
