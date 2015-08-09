package com.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.IManagerDao;
import com.portal.entity.Manager;
import com.portal.service.IManagerService;

@Service
public class ManagerService implements IManagerService {

  @Autowired
  IManagerDao managerDao;

  @Override
  public Manager create(Manager manager) {
    // TODO Auto-generated method stub
    return managerDao.save(manager);
  }

  @Override
  public Manager findByPhone(String mobilePhone) {
    // TODO Auto-generated method stub
    return managerDao.findByPhone(mobilePhone);
  }

  @Override
  public Manager findOne(Long id) {
    // TODO Auto-generated method stub
    return managerDao.findById(id);
  }

}
