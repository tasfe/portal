package com.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.ITrustDao;
import com.portal.entity.Trust;
import com.portal.service.ITrustService;

@Service
public class TrustService implements ITrustService {

  @Autowired
  ITrustDao trustDao;

  @Override
  public void create(Trust trust) {
    trustDao.save(trust);

  }

  @Override
  public void delete(String ids) {
    trustDao.deleteByIds(ids);

  }

  @Override
  public List<Trust> findByKeyWord(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return trustDao.findByKeyWord(params);
  }

  @Override
  public List<Trust> findList(Map<String, Object> params) {
    return trustDao.findList(params);
  }

  @Override
  public Long findListCount(Map<String, Object> params) {
    return trustDao.findListCount(params);
  }

  @Override
  public Trust findOne(Long id) {
    // TODO Auto-generated method stub
    return trustDao.findById(id);
  }

  @Override
  public void update(Trust trust) {
    // TODO Auto-generated method stub
    trustDao.update(trust);
  }

}
