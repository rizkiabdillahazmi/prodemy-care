package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DonationDao;
import com.app.model.Donation;

@Service
@Transactional
public class DonationServiceImpl implements DonationService{
	@Autowired
	private DonationDao dao;
	
	@Override
	public Donation findById(Long id) throws Exception {
		return dao.findById(id);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		dao.deleteById(id);
		
	}

	@Override
	public void save(Donation donation) throws Exception {
		dao.save(donation);
	}
	
	@Override
    public void update(Donation donation) throws Exception {
        dao.update(donation);
    }
	
	@Override
	public List<Donation> findAll() throws Exception {
		return dao.findAll();
	}

    @Override
    public List<Donation> homeFindAll() throws Exception {
        return dao.homeFindAll();
    }

}
