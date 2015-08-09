package com.portal.service;

import com.portal.entity.Manager;

public interface IManagerService {

  public Manager create(Manager manager);

  public Manager findByPhone(String mobilePhone);

  public Manager findOne(Long id);
}
