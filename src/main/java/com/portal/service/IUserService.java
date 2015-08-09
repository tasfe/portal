package com.portal.service;

import java.util.List;
import java.util.Map;

import com.portal.entity.User;

public interface IUserService {

  public List<User> findAllBankDtos();

  /**
   * 模糊查询开户支行
   * 
   * @param priviceName
   * @param cityName
   * @param bankName
   * @param linkBranName
   * @return
   */
  public List<Map<String, String>> getLikeBank(String province, String cityName, String bankName, String linkBranName);

  /**
   * 根据省份,城市和银行条件来查询开户行
   * 
   * @param priviceName
   * @param cityName
   * @param bankName
   * @return
   */
  public List<Map<String, String>> getOpenBank(String province, String cityName, String bankName);

  /**
   * 根据省份来查询城市
   * 
   * @param queryPrivice
   * @return
   */
  public User Login(String name);

}
