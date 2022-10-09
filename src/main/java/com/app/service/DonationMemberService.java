package com.app.service;

import java.util.List;

import com.app.model.DonationMember;

public interface DonationMemberService {
    public DonationMember findById(long id) throws Exception;
    public void deleteById(long id) throws Exception;
    public void save(DonationMember donationMember) throws Exception;
    public void update(DonationMember donationMember) throws Exception;
    public List<DonationMember> findAll() throws Exception;
    public List<DonationMember> findAllById(long id) throws Exception;
}
