package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PaymentDao;
import com.app.model.Payment;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentDao dao;
	
	@Override
	public Payment findById(int id) throws Exception {
		return dao.findById(id);
	}

	@Override
	public void deleteById(int id) throws Exception {
		dao.deleteById(id);
		
	}

	@Override
	public void insert(Payment pay) throws Exception {
		dao.insert(pay);
	}

	@Override
	public void update(Payment pay) throws Exception {
		dao.update(pay);
	}

	@Override
	public List<Payment> findAll() throws Exception {
		return dao.findAll();
	}

}
