package com.portal.service;

import com.portal.entity.Customer;

public interface ICustomerService {

  public Customer create(Customer customer);

  public Customer findByPhone(String mobilePhone);

}
