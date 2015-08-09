package com.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.ICustomerDao;
import com.portal.entity.Customer;
import com.portal.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

  @Autowired
  ICustomerDao customerDao;

  /**
   * 注册新用户
   */
  @Override
  public Customer create(Customer customer) {
    // TODO Auto-generated method stub
    return customerDao.save(customer);
  }

  @Override
  public Customer findByPhone(String mobilePhone) {
    // TODO Auto-generated method stub
    return customerDao.findByPhone(mobilePhone);
  }

}
