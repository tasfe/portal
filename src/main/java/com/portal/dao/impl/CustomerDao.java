package com.portal.dao.impl;

import org.springframework.stereotype.Service;

import com.portal.common.PageEntity;
import com.portal.common.PagingResult;
import com.portal.dao.ICustomerDao;
import com.portal.entity.Customer;

@Service
public class CustomerDao extends BaseDao<Customer, Long> implements ICustomerDao {

  private final String namespace = Customer.class.getName();

  @Override
  public Customer findByPhone(String mobilePhone) {
    // TODO Auto-generated method stub
    return sqlSession.selectOne(namespace + ".findByPhone", mobilePhone);
  }

  @Override
  public PagingResult<Customer> selectPagination(PageEntity param) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(Customer t) {
    super.update("update", t);
  }
}
