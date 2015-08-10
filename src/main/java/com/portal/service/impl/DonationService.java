package com.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.IDonationDao;
import com.portal.entity.Donation;
import com.portal.service.IDonationService;

@Service
public class DonationService implements IDonationService {

  @Autowired
  IDonationDao donationDao;

  @Override
  public void create(Donation donation) {
    donationDao.save(donation);

  }

  @Override
  public void delete(String ids) {
    // TODO Auto-generated method stub
    donationDao.deleteByIds(ids);
  }

  @Override
  public List<Donation> findByKeyWord(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return donationDao.findByKeyWord(params);
  }

  @Override
  public List<Donation> findList(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return donationDao.findList(params);
  }

  @Override
  public Long findListCount(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return donationDao.findListCount(params);
  }

  @Override
  public Donation findOne(Long id) {
    // TODO Auto-generated method stub
    return donationDao.findById(id);
  }

  @Override
  public void update(Donation donation) {
    // TODO Auto-generated method stub
    donationDao.update(donation);
  }

}
