package com.app.service;

import java.util.List;

import com.app.model.Payment;

public interface PaymentService {
	public Payment findById(int id) throws Exception;
	public void deleteById(int id) throws Exception;
	public void insert(Payment pay) throws Exception;
	public void update(Payment pay) throws Exception;
	public List<Payment> findAll() throws Exception;
}
