package com.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.IFundDao;
import com.portal.entity.Fund;
import com.portal.service.IFundService;

@Service
public class FundService implements IFundService {

  @Autowired
  IFundDao fundDao;

  @Override
  public void create(Fund fund) {
    fundDao.save(fund);

  }

  @Override
  public void delete(String ids) {
    fundDao.deleteByIds(ids);

  }

  @Override
  public List<Fund> findByKeyWord(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return fundDao.findByKeyWord(params);
  }

  @Override
  public List<Fund> findList(Map<String, Object> params) {
    return fundDao.findList(params);
  }

  @Override
  public Long findListCount(Map<String, Object> params) {
    return fundDao.findListCount(params);
  }

  @Override
  public Fund findOne(Long id) {
    // TODO Auto-generated method stub
    return fundDao.findById(id);
  }

}
