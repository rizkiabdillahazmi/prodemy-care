package com.app.dao;

import java.util.List;

import com.app.model.Donation;

public interface DonationDao {
	public Donation findById(Long id) throws Exception;
	public void deleteById(Long id) throws Exception;
	public void save(Donation donation) throws Exception;
	public void update(Donation donation) throws Exception;
	public List<Donation> findAll() throws Exception;
	public List<Donation> homeFindAll() throws Exception;
}