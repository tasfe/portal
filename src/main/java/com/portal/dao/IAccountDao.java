package com.portal.dao;

import com.portal.entity.Account;

public interface IAccountDao extends IBaseDao<Account, Long> {

  public Account findByPhone(String mobilePhone);

  public Account findByPhoneAndType(String mobilePhone, int userType);
}
