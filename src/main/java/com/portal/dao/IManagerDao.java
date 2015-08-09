package com.portal.dao;

import com.portal.entity.Manager;

public interface IManagerDao extends IBaseDao<Manager, Long> {

  public Manager findByPhone(String mobilePhone);
}
