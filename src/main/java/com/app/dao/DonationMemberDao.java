package com.app.dao;

import java.util.List;

import com.app.model.DonationMember;

public interface DonationMemberDao {
    public DonationMember findById(Long id) throws Exception;
    public void deleteById(Long id) throws Exception;
    public void save(DonationMember donationMember) throws Exception;
    public void update(DonationMember donationMember) throws Exception;
    public List<DonationMember> findAll() throws Exception;
    public List<DonationMember> findAllById(Long id) throws Exception;
}
