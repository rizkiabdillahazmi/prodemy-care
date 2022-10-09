package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DonationMemberDao;
import com.app.model.DonationMember;

@Service
@Transactional
public class DonationMemberServiceImpl implements DonationMemberService{

    @Autowired
    private DonationMemberDao dao;
    
    @Override
    public DonationMember findById(long id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public void deleteById(long id) throws Exception {
        dao.deleteById(id);
    }

    @Override
    public void save(DonationMember donationMember) throws Exception {
        dao.save(donationMember);
    }

    @Override
    public void update(DonationMember donationMember) throws Exception {
        dao.update(donationMember);
    }

    @Override
    public List<DonationMember> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<DonationMember> findAllById(long id) throws Exception {
        return dao.findAllById(id);
    }
    
}
