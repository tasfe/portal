package com.portal.dao;

import com.portal.entity.Customer;

public interface ICustomerDao extends IBaseDao<Customer, Long> {

  public Customer findByPhone(String mobilePhone);
}
