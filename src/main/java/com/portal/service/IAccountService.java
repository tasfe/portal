package com.portal.service;

import com.portal.entity.Account;

public interface IAccountService {

  public void create(Account account);

  /**
   * 通过手机号查找用户···
   * 
   * @param mobilePhone
   * @return
   */
  public Account findByPhone(String mobilePhone);

  /**
   * 通过手机号和类型查找用户···
   * 
   * @param mobilePhone
   * @return
   */
  public Account findByPhoneAndType(String mobilePhone, int userType);

}
