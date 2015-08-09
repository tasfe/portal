package com.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.IAccountDao;
import com.portal.entity.Account;
import com.portal.service.IAccountService;

@Service
public class AccountService implements IAccountService {

  @Autowired
  IAccountDao accountDao;

  @Override
  public void create(Account account) {
    accountDao.save(account);

  }

  @Override
  public Account findByPhone(String mobilePhone) {
    return accountDao.findByPhone(mobilePhone);
  }

  @Override
  public Account findByPhoneAndType(String mobilePhone, int userType) {
    // TODO Auto-generated method stub
    return accountDao.findByPhoneAndType(mobilePhone, userType);
  }

}
